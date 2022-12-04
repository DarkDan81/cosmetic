package com.costetics.backend.repository;

import com.costetics.backend.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByMail(String mail);

    Optional<User> findUserById(Long id);

    Boolean existsUserByMail(String mail);
}
