package com.docfriends.junggu.task.domain.question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    void findMainList() {
        //given
        //when
        List<Object[]> list = questionRepository.findMainList();
        //than
        assertEquals(9, list.size());
        assertEquals(10, list.get(0).length);
    }
}