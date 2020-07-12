package com.docfriends.junggu.task.domain.question;

import com.docfriends.junggu.task.domain.question.QuestionDTO.MainList;
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
        Long answerCount = 2L;

        //when
        QuestionDTO.MainList dto = new MainList(title,	content,	tag,	createDate, answerCount);

        //than
        assertEquals(title, dto.getTitle());
        assertEquals(content, dto.getContent());
        assertEquals(tag, dto.getTag());
        assertEquals(createDate, dto.getCreateDate());
        assertEquals(answerCount, dto.getAnswerCount());
    }
}