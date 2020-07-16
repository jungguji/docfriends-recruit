package com.docfriends.junggu.task.domain.answer;

import com.docfriends.junggu.task.domain.question.Question;
import com.docfriends.junggu.task.domain.user.doctor.Doctor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
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

    @Builder
    public Answer (String content, String tag, LocalDateTime createDate, Question question, Doctor doctor) {
        this.content = content;
        this.tag = tag;
        this.createDate = createDate;
        this.question = question;
        this.doctor = doctor;
    }

}
