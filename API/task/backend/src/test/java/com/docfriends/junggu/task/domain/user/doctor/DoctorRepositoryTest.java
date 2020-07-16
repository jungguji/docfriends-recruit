package com.docfriends.junggu.task.domain.user.doctor;

import com.docfriends.junggu.task.domain.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(value = "classpath:application-test.properties")
class DoctorRepositoryTest {

    @Autowired
    DoctorRepository doctorRepository;

    @Test
    void findByUserId() {
        //given

        String userId = "user_id 1";
        String pw = "password 1";
        String name = "의사 1";

        Doctor doctor = Doctor.builder()
                .userId(userId)
                .password(pw)
                .name(name)
                .build();

        doctorRepository.save(doctor);

        //when
        User given = doctorRepository.findByUserId(userId);

        //than
        assertEquals(userId, given.getUserId());
        assertEquals(pw, given.getPassword());
        assertEquals(name, given.getName());
    }
}