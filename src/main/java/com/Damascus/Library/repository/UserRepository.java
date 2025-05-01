package com.Damascus.Library.repository;

import com.Damascus.Library.model.entity.User;
import com.Damascus.Library.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    List<User> findByActive(boolean active);
    List<User> findByRole(Role role);


}
