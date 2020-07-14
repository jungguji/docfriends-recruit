package com.docfriends.junggu.task.web;

import com.docfriends.junggu.task.service.LoginService;
import com.docfriends.junggu.task.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class LoginControllerTest {

    @Value("${custom.clientId}")
    String clientId;

    @Value("${custom.clientSecret}")
    String clientSecret;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LoginService loginService;

    @MockBean
    QuestionService questionService;

    @Test
    void getJwtToken() throws Exception {
        //when & then
        this.mockMvc.perform(post("/oauth/token")
                .with(httpBasic(clientId, clientSecret))
                .param("username", "user_id 1")
                .param("password", "password 1")
                .param("grant_type", "password")
        ).andDo(print());
    }
}