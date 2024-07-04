package com.example.myjpa;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<PhoneBookEntity, Long> @Entity 로 선언된 클래스만 올수있다.
public interface PhoneBookJpaRepository extends JpaRepository<PhoneBookEntity, Long> {
}
