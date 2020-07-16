package com.docfriends.junggu.task.domain.question;

import com.docfriends.junggu.task.domain.answer.Answer;
import com.docfriends.junggu.task.domain.user.general.GeneralUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String tag;
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "generalUser_id")
    private GeneralUser generalUser;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @Builder
    public Question(String title, String content, String tag, LocalDateTime createDate, GeneralUser generalUser, List<Answer> answers) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.createDate = createDate;
        this.generalUser = generalUser;
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

}
