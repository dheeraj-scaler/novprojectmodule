package com.scaler.bmsaug24.repositories;

import com.scaler.bmsaug24.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    // Get show by id
    Optional<Show> findById(Long id);
}
