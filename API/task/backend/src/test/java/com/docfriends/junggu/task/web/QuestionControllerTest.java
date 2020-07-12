package com.docfriends.junggu.task.web;

import com.docfriends.junggu.task.web.dto.AnswerDTO;
import com.docfriends.junggu.task.web.dto.QuestionDTO;
import com.docfriends.junggu.task.web.dto.QuestionDTO.MainView;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void home() throws Exception {
        final ResultActions action = mockMvc.perform(get("/"))
                .andDo(print());

        action.andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

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

        String expected = "[{\"title\":\"질문글 제목 01\",\"content\":\"질문내용 01\",\"tag\":\"tag 01\",\"createDate\":\"2020-07-11\",\"answerCount\":2},{\"title\":\"질문글 제목 03\",\"content\":\"질문내용 03\",\"tag\":\"tag 03\",\"createDate\":\"2020-07-11\",\"answerCount\":1},{\"title\":\"질문글 제목 04\",\"content\":\"질문내용 04\",\"tag\":\"tag 04\",\"createDate\":\"2020-07-11\",\"answerCount\":1},{\"title\":\"질문글 제목 05\",\"content\":\"질문내용 05\",\"tag\":\"tag 05\",\"createDate\":\"2020-07-11\",\"answerCount\":1},{\"title\":\"질문글 제목 06\",\"content\":\"질문내용 06\",\"tag\":\"tag 06\",\"createDate\":\"2020-07-11\",\"answerCount\":1},{\"title\":\"질문글 제목 07\",\"content\":\"질문내용 07\",\"tag\":\"tag 07\",\"createDate\":\"2020-07-11\",\"answerCount\":1},{\"title\":\"질문글 제목 08\",\"content\":\"질문내용 08\",\"tag\":\"tag 08\",\"createDate\":\"2020-07-11\",\"answerCount\":1},{\"title\":\"질문글 제목 09\",\"content\":\"질문내용 09\",\"tag\":\"tag 09\",\"createDate\":\"2020-07-11\",\"answerCount\":1}]";
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void testfindConsultDetail() throws Exception {
        //given

        //given
        LocalDate time = LocalDate.of(2020, 07,11);
        LocalDate time1 = LocalDate.of(2020, 07,11);

        String title = " 질문글 제목 01";
        String content = "질문내용 01";
        String tag = "tag 01";
        String answerContent1 = "답글답글답글 1";
        String answerContent2 = "답글답글답글 2";
        String doctor1 = "의사 1";
        String doctor2 = "의사 2";
        String hospital = "병원 1";
        String address = "서울시 1";

        AnswerDTO.ConsultDetail answer1 = AnswerDTO.ConsultDetail
                .builder()
                .answerContent(answerContent1)
                .answerCreateDate(time1)
                .doctorName(doctor1)
                .hospitalName(hospital)
                .hospitalAddress(address)
                .build();

        AnswerDTO.ConsultDetail answer2 = AnswerDTO.ConsultDetail
                .builder()
                .answerContent(answerContent2)
                .answerCreateDate(time1)
                .doctorName(doctor2)
                .hospitalName(hospital)
                .hospitalAddress(address)
                .build();

        List<AnswerDTO.ConsultDetail> answers = Arrays.asList(
                answer1, answer2
        );

        QuestionDTO.ConsultDetail given = QuestionDTO.ConsultDetail
                .builder()
                .title(title)
                .content(content)
                .tag(tag)
                .createDate(time)
                .answers(answers)
                .build();

        given(this.questionService.findConsultDetail(1)).willReturn(given);

        //when
        final ResultActions action = mockMvc.perform(get("/detail/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
        //than
        MvcResult result = action.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String expected = "{\"title\":\" 질문글 제목 01\",\"content\":\"질문내용 01\",\"tag\":\"tag 01\",\"createDate\":\"2020-07-11\",\"answers\":[{\"answerContent\":\"답글답글답글 1\",\"answerCreateDate\":\"2020-07-11\",\"doctorName\":\"의사 1\",\"hospitalName\":\"병원 1\",\"hospitalAddress\":\"서울시 1\"},{\"answerContent\":\"답글답글답글 2\",\"answerCreateDate\":\"2020-07-11\",\"doctorName\":\"의사 2\",\"hospitalName\":\"병원 1\",\"hospitalAddress\":\"서울시 1\"}]}";
        assertEquals(expected, result.getResponse().getContentAsString());
    }
}