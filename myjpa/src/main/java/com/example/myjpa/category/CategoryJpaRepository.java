package com.example.myjpa.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAllByNameContains(String name);
    Optional<CategoryEntity> findByName(String name);
}
