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
            + "    , q.CONTENT              "
            + "    , q.tag                  "
            + "    , q.create_date          "
            + "    , a.content              "
            + "    , a.create_date          "
            + "    , d.name                 "
            + "    , h.name                 "
            + "    , h.address              "
            + "    , h.website_url          "
            + "FROM                         "
            + "    Question q               "
            + "JOIN Answer a                "
            + "    WHERE q.id = a.questionId"
            + "JOIN Doctor d                "
            + "    WHERE a.doctorId = d.id  "
            + "JOIN Hospital h              "
            + "    WHERE d.hospitalId = h.id")
    List<Object[]> findMainList();
}
