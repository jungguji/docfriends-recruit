package com.docfriends.junggu.task.domain.generaluser;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class GeneralUser {

    private Integer id;
    private String userId;
    private String password;
    private String name;

    @Builder
    public GeneralUser(Integer id, String userId, String password, String name) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
}
