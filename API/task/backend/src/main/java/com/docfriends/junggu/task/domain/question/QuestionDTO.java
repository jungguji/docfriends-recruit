package com.docfriends.junggu.task.domain.question;

import lombok.*;

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


}
