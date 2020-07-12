package com.docfriends.junggu.task.service;

import com.docfriends.junggu.task.web.dto.QuestionDTO;
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
        List<Object[]> consultDetailList = questionRepository.findConsultDetail(questionId);

        return null;
    }
}
