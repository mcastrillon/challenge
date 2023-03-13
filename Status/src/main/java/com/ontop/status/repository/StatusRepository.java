package com.ontop.status.repository;

import com.ontop.status.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StatusRepository extends JpaRepository<Status,Long> {

    Page<Status> findByUserIdAndAmountAndTimestamp(Long userId, Float amount, LocalDate timestamp, Pageable pageable);
    List<Status> findAllByUserId(Long userId);

}
