package com.docfriends.junggu.task.web;

import com.docfriends.junggu.task.domain.question.QuestionDTO.MainView;
import com.docfriends.junggu.task.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @Test
    void findQuestionMainList() throws Exception {
        //given
        LocalDate time = LocalDate.of(2020, 07,11);
        LocalDate time1 = LocalDate.of(2020, 07,11);

        List<MainView> givenDTO = Arrays.asList(
                new MainView("질문글 제목 01",	"질문내용 01",	"tag 01",	time, 2L)
                , new MainView("질문글 제목 03",	"질문내용 03",	"tag 03",	time, 1L)
                , new MainView("질문글 제목 04",	"질문내용 04",	"tag 04",	time, 1L)
                , new MainView("질문글 제목 05",	"질문내용 05",	"tag 05",	time, 1L)
                , new MainView("질문글 제목 06",	"질문내용 06",	"tag 06",	time1, 1L)
                , new MainView("질문글 제목 07",	"질문내용 07",	"tag 07",	time1, 1L)
                , new MainView("질문글 제목 08",	"질문내용 08",	"tag 08",	time1, 1L)
                , new MainView("질문글 제목 09",	"질문내용 09",	"tag 09",	time1, 1L)
        );

        given(this.questionService.getMainList()).willReturn(givenDTO);

        // when
        final ResultActions action = mockMvc.perform(get("/main")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        MvcResult result = action.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        result.getResponse().getContentAsString();
    }
}