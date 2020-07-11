package com.docfriends.junggu.task.domain.hospital;

import com.docfriends.junggu.task.domain.doctor.Doctor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
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
}
