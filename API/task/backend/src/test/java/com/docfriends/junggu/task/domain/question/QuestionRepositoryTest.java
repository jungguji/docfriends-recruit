package com.docfriends.junggu.task.domain.question;

import com.docfriends.junggu.task.domain.answer.Answer;
import com.docfriends.junggu.task.domain.doctor.Doctor;
import com.docfriends.junggu.task.domain.generaluser.GeneralUser;
import com.docfriends.junggu.task.domain.hospital.Hospital;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

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
    }
}