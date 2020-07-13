package com.docfriends.junggu.task.domain.user.general;

import com.docfriends.junggu.task.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GeneralUserRepository extends JpaRepository<GeneralUser, Long> {

    @Query("SELECT user FROM GeneralUser user WHERE userId =:userId")
    @Transactional(readOnly = true)
    User findByUserId(@Param("userId") String userId);
}
