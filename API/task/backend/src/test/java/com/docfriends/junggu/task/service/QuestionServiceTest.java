package com.docfriends.junggu.task.service;

import com.docfriends.junggu.task.domain.question.QuestionRepository;
import com.docfriends.junggu.task.web.dto.AnswerDTO;
import com.docfriends.junggu.task.web.dto.QuestionDTO;
import com.docfriends.junggu.task.web.dto.QuestionDTO.MainView;
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

    LocalDateTime time;
    LocalDateTime time1;

    @BeforeEach
    public void setUp() {
        this.questionService = new QuestionService(questionRepository);
        this.time = LocalDateTime.of(2020, 07,11,19,51,04);
        this.time1 = LocalDateTime.of(2020, 07,11,19,51,05);
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

    @Test
    void findConsultDetail() {
        //given

        String title = " 질문글 제목 01";
        String content = "질문내용 01";
        String tag = "tag 01";
        String answerContent1 = "답글답글답글 1";
        String answerContent2 = "답글답글답글 2";
        String doctor1 = "의사 1";
        String doctor2 = "의사 2";
        String hospital = "병원 1";
        String address = "서울시 1";

        List<Object[]> given = Arrays.asList(
                new Object[] {title,	content,	tag,	time,	answerContent1,	time1,	doctor1,	hospital,	address}
                , new Object[] {title,	content,	tag,	time,	answerContent2,	time1,	doctor2,	hospital,	address}
        );

        given(this.questionRepository.findConsultDetail(1)).willReturn(given);

        AnswerDTO.ConsultDetail answer1 = AnswerDTO.ConsultDetail
                .builder()
                .answerContent(answerContent1)
                .answerCreateDate(time1.toLocalDate())
                .doctorName(doctor1)
                .hospitalName(hospital)
                .hospitalAddress(address)
                .build();

        AnswerDTO.ConsultDetail answer2 = AnswerDTO.ConsultDetail
                .builder()
                .answerContent(answerContent2)
                .answerCreateDate(time1.toLocalDate())
                .doctorName(doctor2)
                .hospitalName(hospital)
                .hospitalAddress(address)
                .build();

        List<AnswerDTO.ConsultDetail> answers = Arrays.asList(
                answer1, answer2
        );

        QuestionDTO.ConsultDetail expected = QuestionDTO.ConsultDetail
                .builder()
                .title(title)
                .content(content)
                .tag(tag)
                .createDate(time.toLocalDate())
                .answers(answers)
                .build();

        //when
        QuestionDTO.ConsultDetail target = this.questionService.findConsultDetail(1);

        //than
        assertThat(target).isNotNull();

        assertEquals(expected.getTitle(), target.getTitle());
        assertEquals(expected.getContent(), target.getContent());
        assertEquals(expected.getTag(), target.getTag());
        assertEquals(expected.getCreateDate(), target.getCreateDate());

        for (int i = 0; i < target.getAnswers().size(); i++) {
            AnswerDTO.ConsultDetail targetAnswer = target.getAnswers().get(i);
            AnswerDTO.ConsultDetail expectedAnswer = expected.getAnswers().get(i);

            assertEquals(expectedAnswer.getAnswerContent(), targetAnswer.getAnswerContent());
            assertEquals(expectedAnswer.getAnswerCreateDate(), targetAnswer.getAnswerCreateDate());
            assertEquals(expectedAnswer.getDoctorName(), targetAnswer.getDoctorName());
            assertEquals(expectedAnswer.getHospitalName(), targetAnswer.getHospitalName());
            assertEquals(expectedAnswer.getHospitalAddress(), targetAnswer.getHospitalAddress());
        }

    }
}