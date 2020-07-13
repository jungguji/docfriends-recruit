package com.docfriends.junggu.task.domain.user.general;

import com.docfriends.junggu.task.domain.question.Question;
import com.docfriends.junggu.task.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class GeneralUser implements User {

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
