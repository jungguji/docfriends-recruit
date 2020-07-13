package com.docfriends.junggu.task.domain.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT doctor FROM Doctor doctor WHERE userId =:userId")
    @Transactional(readOnly = true)
    Doctor findByUserId(@Param("userId") String userId);
}
