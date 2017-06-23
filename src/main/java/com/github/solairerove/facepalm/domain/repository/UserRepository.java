package com.github.solairerove.facepalm.domain.repository;

import com.github.solairerove.facepalm.domain.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
