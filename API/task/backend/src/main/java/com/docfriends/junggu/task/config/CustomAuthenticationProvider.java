package com.docfriends.junggu.task.config;

import com.docfriends.junggu.task.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;

        User user = (User) loginService.loadUserByUsername(authToken.getName());
        if (user == null) {
            throw new UsernameNotFoundException("아이디 혹은 비밀번호가 올바르지 않습니다.");
        }

        if ((((String) authToken.getCredentials()).equals(user.getPassword()))) {
            throw new BadCredentialsException("아이디 혹은 비밀번호가 올바르지 않습니다.");
        }

        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
