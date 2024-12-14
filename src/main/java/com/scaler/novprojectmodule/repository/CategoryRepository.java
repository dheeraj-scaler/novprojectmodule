package com.scaler.novprojectmodule.repository;

import com.scaler.novprojectmodule.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);
}
