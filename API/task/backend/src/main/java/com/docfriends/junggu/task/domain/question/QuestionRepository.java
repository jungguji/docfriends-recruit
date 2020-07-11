package com.docfriends.junggu.task.domain.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = ""
            + "SELECT                       "
            + "    q.title                  "
            + "    , q.content              "
            + "    , q.tag                  "
            + "    , q.createDate           "
            + "    , a.content              "
            + "    , a.createDate           "
            + "    , d.name                 "
            + "    , h.name                 "
            + "    , h.address              "
            + "    , h.websiteUrl           "
            + "FROM                         "
            + "    Question q               "
            + "JOIN q.answers a		        "
            + "JOIN a.doctor d              "
            + "JOIN d.hospital h            "
            + "WHERE q.id = a.question      "
            + "    AND a.doctor = d.id      "
            + "    AND d.hospital = h.id    ")
    List<Object[]> findMainList();
}
