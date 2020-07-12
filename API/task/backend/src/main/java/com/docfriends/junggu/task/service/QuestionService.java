package com.docfriends.junggu.task.service;

import com.docfriends.junggu.task.web.dto.AnswerDTO;
import com.docfriends.junggu.task.web.dto.QuestionDTO;
import com.docfriends.junggu.task.web.dto.QuestionDTO.ConsultDetail;
import com.docfriends.junggu.task.web.dto.QuestionDTO.MainView;
import com.docfriends.junggu.task.domain.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionDTO.MainView> getMainList() {
        List<Object[]> mainList = questionRepository.findMainList();

        List<QuestionDTO.MainView> convertMainList = new ArrayList<>();

        for (Object[] objArray : mainList) {
            String title = (String) objArray[0];
            String content = (String) objArray[1];
            String tag = (String) objArray[2];
            LocalDate createDate = ((LocalDateTime) objArray[3]).toLocalDate();
            Long answerCount = (Long) objArray[4];

            convertMainList.add(new MainView(title, content, tag, createDate, answerCount));
        }

        return convertMainList;
    }

    public QuestionDTO.ConsultDetail findConsultDetail(Integer questionId) {
        List<Object[]> objectList = questionRepository.findConsultDetail(questionId);

        List<AnswerDTO.ConsultDetail> answers = getAnswers(objectList);

        Object[] questionArray = objectList.get(0);
        String title = (String) questionArray[0];
        String content = (String) questionArray[1];
        String tag = (String) questionArray[2];
        LocalDate createDate = ((LocalDate) questionArray[3]);

        return ConsultDetail.builder()
                .title(title)
                .content(content)
                .tag(tag)
                .createDate(createDate)
                .answers(answers)
                .build();
    }

    private List<AnswerDTO.ConsultDetail> getAnswers(List<Object[]> objectList) {
        List<AnswerDTO.ConsultDetail> answers = new ArrayList<>();

        for (Object[] objArray : objectList) {
            String answerContent = (String) objArray[4];
            LocalDate answerCreateDate = (LocalDate) objArray[5];
            String doctor = (String) objArray[6];
            String hospital = (String) objArray[7];
            String address = (String) objArray[8];

            answers.add(AnswerDTO.ConsultDetail.builder()
                    .answerContent(answerContent)
                    .answerCreateDate(answerCreateDate)
                    .doctorName(doctor)
                    .hospitalName(hospital)
                    .hospitalAddress(address)
                    .build());
        }

        return answers;
    }
}
