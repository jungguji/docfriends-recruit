package com.docfriends.junggu.task.domain.answer;

import com.docfriends.junggu.task.domain.doctor.Doctor;
import com.docfriends.junggu.task.domain.question.Question;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String tag;
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
