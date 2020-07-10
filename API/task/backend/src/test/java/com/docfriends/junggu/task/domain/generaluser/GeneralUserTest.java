package com.docfriends.junggu.task.domain.generaluser;

import com.docfriends.junggu.task.domain.generaluser.GeneralUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralUserTest {

    @Test
    public void generalUserTest() {
        //given
        int id = 1;
        String userId = "test";
        String passwrd = "qwe123";
        String name = "jgji";

        //when
        GeneralUser user = GeneralUser.builder()
                .id(id)
                .userId(userId)
                .password(passwrd)
                .name(name)
                .build();

        //than

        assertEquals(id, user.getId());
        assertEquals(userId, user.getUserId());
        assertEquals(passwrd, user.getPassword());
        assertEquals(name, user.getName());
    }
}