package com.docfriends.junggu.task.domain.doctor;

import com.docfriends.junggu.task.domain.answer.Answer;
import com.docfriends.junggu.task.domain.hospital.Hospital;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name="hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Answer> answers = new ArrayList<>();
}
