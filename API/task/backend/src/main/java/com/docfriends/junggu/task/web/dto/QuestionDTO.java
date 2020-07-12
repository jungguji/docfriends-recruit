package com.docfriends.junggu.task.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public class QuestionDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MainView {
        private final String title;
        private final String content;
        private String tag;
        private final LocalDate createDate;
        private final Long answerCount;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ConsultDetail {
        private final String title;
        private final String content;
        private String tag;
        private final LocalDate createDate;
        private final String answerContent;
        private final LocalDate answerCreateDate;
        private final String doctorName;
        private final String hospitalName;
        private final String hospitalAddress;
    }
}
