package com.Damascus.Library.repository;

import com.Damascus.Library.model.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {

    boolean existsByEmail(String email);

}
