package com.docfriends.junggu.task.service;

import com.docfriends.junggu.task.domain.user.doctor.Doctor;
import com.docfriends.junggu.task.domain.user.doctor.DoctorRepository;
import com.docfriends.junggu.task.domain.user.general.GeneralUser;
import com.docfriends.junggu.task.domain.user.general.GeneralUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application-test.properties")
class LoginServiceTest {

    @MockBean
    private GeneralUserRepository generalUserRepository;

    @MockBean
    private DoctorRepository doctorRepository;

    private LoginService loginService;

    @BeforeEach
    void setUp() {
        this.loginService = new LoginService(generalUserRepository, doctorRepository);
    }

    @Test
    void loadUserByUsername_일반유저() {
        //given
        String userId = "일반유저";
        String pw = "일반비밀번호";
        String name = "지중구";

        GeneralUser givenUser = GeneralUser.builder()
                .userId(userId)
                .password(pw)
                .name(name)
                .build();

        this.generalUserRepository.save(givenUser);
        given(this.generalUserRepository.findByUserId(userId)).willReturn(givenUser);

        //when
        UserDetails user = loginService.loadUserByUsername(userId);
        //than

        assertThat(user).isNotNull();
        assertEquals(userId, user.getUsername());
        assertEquals(pw, user.getPassword());
    }

    @Test
    void loadUserByUsername_의사() {
        //given
        String userId = "의사입니다";
        String pw = "의사비밀번호";
        String name = "진짜의사";

        Doctor doctor = Doctor.builder()
                .userId(userId)
                .password(pw)
                .name(name)
                .build();

        this.doctorRepository.save(doctor);

        given(this.generalUserRepository.findByUserId("의사라서없음")).willReturn(null);
        given(this.doctorRepository.findByUserId(userId)).willReturn(doctor);

        //when
        UserDetails user = loginService.loadUserByUsername(userId);
        //than

        assertThat(user).isNotNull();
        assertEquals(userId, user.getUsername());
        assertEquals(pw, user.getPassword());
    }
}