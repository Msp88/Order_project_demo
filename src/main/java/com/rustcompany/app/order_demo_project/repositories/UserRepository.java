package com.rustcompany.app.order_demo_project.repositories;

import com.rustcompany.app.order_demo_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
