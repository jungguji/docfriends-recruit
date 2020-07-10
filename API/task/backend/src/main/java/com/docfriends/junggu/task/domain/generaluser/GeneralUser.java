package com.docfriends.junggu.task.domain.generaluser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@Builder
@Entity
public class GeneralUser {

    private Integer id;
    private String userId;
    private String password;
    private String name;
}
