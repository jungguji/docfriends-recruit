package com.docfriends.junggu.task.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class AnswerDTO {
    private static final String ESCAPE_NEWLINE = "\\n";
    private static final String HTML_NEWLINE = "<br />";

    @Getter
    public static class ConsultDetail {
        private final String answerContent;
        private final LocalDate answerCreateDate;
        private final String doctorName;
        private final String hospitalName;
        private final String hospitalAddress;

        @Builder
        public ConsultDetail(String answerContent, LocalDate answerCreateDate, String doctorName, String hospitalName, String hospitalAddress) {
            this.answerContent = answerContent.replace(ESCAPE_NEWLINE, HTML_NEWLINE);
            this.answerCreateDate = answerCreateDate;
            this.doctorName = doctorName;
            this.hospitalName = hospitalName;
            this.hospitalAddress = hospitalAddress;
        }
    }
}
