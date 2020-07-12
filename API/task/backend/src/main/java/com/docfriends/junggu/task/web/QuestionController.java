package com.docfriends.junggu.task.web;

import com.docfriends.junggu.task.web.dto.QuestionDTO;
import com.docfriends.junggu.task.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/main", produces = "application/json")
    @ResponseBody
    public List<QuestionDTO.MainView> findQuestionMainList() {
        return questionService.getMainList();
    }

    @GetMapping(value = "/detail/{id}")
    @ResponseBody
    public QuestionDTO.ConsultDetail findConsultDetail(@PathVariable("id") int id) {
        return questionService.findConsultDetail(id);
    }
}
