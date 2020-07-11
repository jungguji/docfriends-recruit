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
    private Integer questionId;
    private String content;
    private String tag;
    private LocalDateTime createDate;
    private Integer doctorId;

    @ManyToOne
    @JoinColumn(name = "id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "id")
    private Doctor doctor;
}
