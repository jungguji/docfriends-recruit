package com.docfriends.junggu.task.domain.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class QuestionDTO {
    private final String title;
    private final String content;
    private String tag;
    private final LocalDateTime createDate;
}
