package com.docfriends.junggu.task.domain.generaluser;

import com.docfriends.junggu.task.domain.user.general.GeneralUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralUserTest {

    @Test
    public void generalUserTest() {
        //given
        String userId = "test";
        String passwrd = "qwe123";
        String name = "jgji";

        //when
        GeneralUser user = GeneralUser.builder()
                .userId(userId)
                .password(passwrd)
                .name(name)
                .build();

        //than

        assertEquals(userId, user.getUserId());
        assertEquals(passwrd, user.getPassword());
        assertEquals(name, user.getName());
    }
}