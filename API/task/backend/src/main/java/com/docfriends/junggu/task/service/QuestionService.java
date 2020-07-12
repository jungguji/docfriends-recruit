package com.docfriends.junggu.task.service;

import com.docfriends.junggu.task.domain.question.QuestionDTO;
import com.docfriends.junggu.task.domain.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionDTO.MainList> getMainList() {
        return new ArrayList<>();
    }
}
