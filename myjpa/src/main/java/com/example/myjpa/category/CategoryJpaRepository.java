package com.example.myjpa.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
    // 하이버네이트 (알아서 쿼리문을 만들어주는 메소드)
    List<CategoryEntity> findAllByNameContains(String name);
    Optional<CategoryEntity> findByName(String name);
}
