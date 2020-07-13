package com.docfriends.junggu.task.domain.user.general;

import com.docfriends.junggu.task.domain.user.User;
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
class GeneralUserRepositoryTest {

    @Autowired
    GeneralUserRepository generalUserRepository;

    @Test
    void findByUserId() {
        //given
        String userId = "user_id 1";
        String pw = "password 1";
        String name = "일반유저 1";

        //when
        User target = generalUserRepository.findByUserId(userId);

        //than
        assertEquals(userId, target.getUserId());
        assertEquals(pw, target.getPassword());
        assertEquals(name, target.getName());
    }
}