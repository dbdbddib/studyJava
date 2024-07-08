package com.example.myjpa.phonebook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository를 확장하여 기본적인 CRUD(Create, Read, Update, Delete)기능을 제공
// <PhoneBookEntity, Long>
// PhoneBookEntity: JPA 리포지토리가 관리할 엔티티 클래스입니다.
// Long: 기본키의 데이터타입 (PhoneBookEntity 클래스의 id가 기본키이며 id의 타입은 Long)
//findAllByNameContains(String name) name(매개변수) Entity 클래스에서 찾는다.

public interface PhoneBookJpaRepository extends JpaRepository<PhoneBookEntity, Long> {
    List<PhoneBookEntity> findAllByNameContains(String name);
    List<PhoneBookEntity> findAllByCategory(ECategory category);
    List<PhoneBookEntity> findAllByPhoneNumberContains(String phoneNumber);
    List<PhoneBookEntity> findAllByEmailContains(String email);
}
