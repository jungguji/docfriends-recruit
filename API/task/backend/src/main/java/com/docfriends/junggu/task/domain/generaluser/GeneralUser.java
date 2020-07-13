package com.docfriends.junggu.task.domain.generaluser;

import com.docfriends.junggu.task.domain.question.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class GeneralUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String password;
    private String name;

    @OneToMany(mappedBy = "generalUser")
    private List<Question> questions = new ArrayList<>();

    @Builder
    public GeneralUser(String userId, String password, String name, List<Question> questions) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.questions = questions;
    }
}
