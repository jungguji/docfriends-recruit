package com.docfriends.junggu.task.domain.question;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDTOTest {

    @Test
    void builder() {
        //given
        String title = "테스트입니다.";
        String content = "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용";
        String tag = "태그태그, 한방";
        LocalDateTime createDate = LocalDateTime.now();

        //when
        QuestionDTO dto = QuestionDTO.builder()
                .title(title)
                .content(content)
                .tag(tag)
                .createDate(createDate)
                .build();

        //than
        assertEquals(title, dto.getTitle());
        assertEquals(content, dto.getContent());
        assertEquals(tag, dto.getTag());
        assertEquals(createDate, dto.getCreateDate());
    }
}