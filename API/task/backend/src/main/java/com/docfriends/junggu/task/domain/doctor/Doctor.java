package com.docfriends.junggu.task.domain.doctor;

import com.docfriends.junggu.task.domain.hospital.Hospital;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Builder
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String password;
    private String name;

    @ManyToOne
    @JoinColumn(name="id")
    private Hospital hospital;
}
