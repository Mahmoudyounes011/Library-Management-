package com.Damascus.Library.repository;

import com.Damascus.Library.model.entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    boolean existsByBookIdAndPatronIdAndReturnedFalse(Long bookId, Long patronId);
    boolean existsByBookIdAndReturnedFalse(Long bookId);
}