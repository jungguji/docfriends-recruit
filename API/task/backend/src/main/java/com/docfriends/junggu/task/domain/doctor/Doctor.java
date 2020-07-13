package com.docfriends.junggu.task.domain.doctor;

import com.docfriends.junggu.task.domain.answer.Answer;
import com.docfriends.junggu.task.domain.hospital.Hospital;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
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

    @Builder
    public Doctor(String userId, String password, String name, Hospital hospital, List<Answer> answers) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.hospital = hospital;
        this.answers = answers;
    }
}
