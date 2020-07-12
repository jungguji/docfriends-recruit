package com.docfriends.junggu.task.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class AnswerDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ConsultDetail {
        private final String answerContent;
        private final LocalDate answerCreateDate;
        private final String doctorName;
        private final String hospitalName;
        private final String hospitalAddress;
    }
}
