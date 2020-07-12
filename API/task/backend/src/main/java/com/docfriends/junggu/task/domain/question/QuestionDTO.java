package com.docfriends.junggu.task.domain.question;

import lombok.*;

import java.time.LocalDateTime;


public class QuestionDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MainList {
        private final String title;
        private final String content;
        private String tag;
        private final LocalDateTime createDate;
        private final Long answerCount;
    }
}
