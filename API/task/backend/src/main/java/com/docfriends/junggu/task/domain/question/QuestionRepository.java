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
            + "    , count(a.id)            "
            + "FROM                         "
            + "    Question q               "
            + "JOIN q.answers a		        "
            + "WHERE q.id = a.question      "
            + "GROUP BY q.id                "
            + "ORDER BY q.id                ")
    List<Object[]> findMainList();
}
