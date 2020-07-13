package com.docfriends.junggu.task.domain.hospital;

import com.docfriends.junggu.task.domain.user.doctor.Doctor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String websiteUrl;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors = new ArrayList<>();

    @Builder
    public Hospital(String name, String address, String websiteUrl, List<Doctor> doctors) {
        this.name = name;
        this.address = address;
        this.websiteUrl = websiteUrl;
        this.doctors = doctors;
    }
}
