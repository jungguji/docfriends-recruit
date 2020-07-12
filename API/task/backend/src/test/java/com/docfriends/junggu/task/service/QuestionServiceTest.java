package com.docfriends.junggu.task.service;

import com.docfriends.junggu.task.domain.question.QuestionDTO;
import com.docfriends.junggu.task.domain.question.QuestionDTO.MainView;
import com.docfriends.junggu.task.domain.question.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class QuestionServiceTest {

    @MockBean
    private QuestionRepository questionRepository;

    private QuestionService questionService;

    @BeforeEach
    public void setUp() {
        this.questionService = new QuestionService(questionRepository);
    }

    @Test
    void getMainView() {
        //given
        LocalDateTime time = LocalDateTime.of(2020, 07,11,19,51,04);
        LocalDateTime time1 = LocalDateTime.of(2020, 07,11,19,51,05);

        List<Object[]> given = Arrays.asList(
                new Object[]   {"질문글 제목 01",	"질문내용 01",	"tag 01",	time, 2L}
                , new Object[] {"질문글 제목 03",	"질문내용 03",	"tag 03",	time, 1L}
                , new Object[] {"질문글 제목 04",	"질문내용 04",	"tag 04",	time, 1L}
                , new Object[] {"질문글 제목 05",	"질문내용 05",	"tag 05",	time, 1L}
                , new Object[] {"질문글 제목 06",	"질문내용 06",	"tag 06",	time1, 1L}
                , new Object[] {"질문글 제목 07",	"질문내용 07",	"tag 07",	time1, 1L}
                , new Object[] {"질문글 제목 08",	"질문내용 08",	"tag 08",	time1, 1L}
                , new Object[] {"질문글 제목 09",	"질문내용 09",	"tag 09",	time1, 1L}
        );

        given(this.questionRepository.findMainList()).willReturn(given);

        List<QuestionDTO.MainView> givenDTO = Arrays.asList(
                new MainView("질문글 제목 01",	"질문내용 01",	"tag 01",	time.toLocalDate(), 2L)
                , new MainView("질문글 제목 03",	"질문내용 03",	"tag 03",	time.toLocalDate(), 1L)
                , new MainView("질문글 제목 04",	"질문내용 04",	"tag 04",	time.toLocalDate(), 1L)
                , new MainView("질문글 제목 05",	"질문내용 05",	"tag 05",	time.toLocalDate(), 1L)
                , new MainView("질문글 제목 06",	"질문내용 06",	"tag 06",	time1.toLocalDate(), 1L)
                , new MainView("질문글 제목 07",	"질문내용 07",	"tag 07",	time1.toLocalDate(), 1L)
                , new MainView("질문글 제목 08",	"질문내용 08",	"tag 08",	time1.toLocalDate(), 1L)
                , new MainView("질문글 제목 09",	"질문내용 09",	"tag 09",	time1.toLocalDate(), 1L)
        );

        //when
        List<QuestionDTO.MainView> targetList = this.questionService.getMainList();

        //than
        assertThat(targetList).isNotEmpty();

        for (int i = 0; i < targetList.size(); i++) {
            MainView target = targetList.get(i);
            MainView expected = givenDTO.get(i);

            assertEquals(expected.getTitle(), target.getTitle());
            assertEquals(expected.getContent(), target.getContent());
            assertEquals(expected.getTag(), target.getTag());
            assertEquals(expected.getCreateDate(), target.getCreateDate());
            assertEquals(expected.getAnswerCount(), target.getAnswerCount());
        }
    }
}