package com.docfriends.junggu.task.domain.generaluser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GeneralUserRepository extends JpaRepository<GeneralUser, Long> {

    @Query("SELECT user FROM GeneralUser user WHERE userId =:userId")
    @Transactional(readOnly = true)
    GeneralUser findByUserId(@Param("userId") String userId);
}
