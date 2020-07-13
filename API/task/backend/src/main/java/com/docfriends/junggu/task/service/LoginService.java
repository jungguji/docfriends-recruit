package com.docfriends.junggu.task.service;

import com.docfriends.junggu.task.domain.user.User;
import com.docfriends.junggu.task.domain.user.doctor.DoctorRepository;
import com.docfriends.junggu.task.domain.user.general.GeneralUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final GeneralUserRepository generalUserRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = generalUserRepository.findByUserId(userId);
        if (user == null) {
            user = doctorRepository.findByUserId(userId);
        }

        if (user == null) {
            return null;
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), authorities);
    }
}
