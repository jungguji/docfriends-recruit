package com.docfriends.junggu.task.domain.answer;

import com.docfriends.junggu.task.domain.question.Question;
import com.docfriends.junggu.task.domain.user.doctor.Doctor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "answer")
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
