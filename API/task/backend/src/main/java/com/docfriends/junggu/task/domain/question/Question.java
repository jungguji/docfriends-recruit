package com.docfriends.junggu.task.domain.question;

import com.docfriends.junggu.task.domain.answer.Answer;
import com.docfriends.junggu.task.domain.user.general.GeneralUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;
    private final String title;
    private final String content;
    private String tag;
    private final LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "generalUser_id")
    private GeneralUser generalUser;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();
}
