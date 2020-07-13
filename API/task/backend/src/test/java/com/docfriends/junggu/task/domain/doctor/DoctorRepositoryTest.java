package com.docfriends.junggu.task.domain.doctor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DoctorRepositoryTest {

    @Autowired
    DoctorRepository doctorRepository;

    @Test
    void findByUserId() {
        //given

        String userId = "user_id 1";
        String pw = "password 1";
        String name = "의사 1";

        //when
        Doctor given = doctorRepository.findByUserId(userId);

        //than
        assertEquals(userId, given.getUserId());
        assertEquals(pw, given.getPassword());
        assertEquals(name, given.getName());
    }
}