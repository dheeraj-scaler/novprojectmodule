package com.scaler.bmsaug24.repositories;

import com.scaler.bmsaug24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByEmail(String email);
}
