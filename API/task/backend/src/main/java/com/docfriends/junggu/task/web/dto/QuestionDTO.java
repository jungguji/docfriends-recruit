package com.docfriends.junggu.task.web.dto;

import com.docfriends.junggu.task.web.dto.AnswerDTO.ConsultDetail;
import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
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
    @NoArgsConstructor
    public static class ConsultDetail {
        private String title;
        private String content;
        private String tag;
        private LocalDate createDate;

        private List<AnswerDTO.ConsultDetail> answers = new ArrayList<>();

        @Builder
        public ConsultDetail(String title, String content, String tag, LocalDate createDate, List<AnswerDTO.ConsultDetail> answers) {
            Assert.notNull(answers, "answers must not be null");
            Assert.notEmpty(answers, "answers must not be empty");
            this.title = title;
            this.content = content;
            this.tag = tag;
            this.createDate = createDate;
            this.answers = answers;
        }
    }
}
