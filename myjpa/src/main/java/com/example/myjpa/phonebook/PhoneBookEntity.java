//Entity 와 JpaRepository 만 있어도 db 연결

package com.example.myjpa.phonebook;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity //엔티티 클래스는 데이터베이스 테이블의 구조를 반영
@Table(name = "phoneBook_tbl")
public class PhoneBookEntity implements IPhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // id 필드의 값을 db에 자동으로 1씩 증가
    private Long id;

    @NotNull
    @Column(length = 50, unique = true)
    private String name;

    @NotNull
    private ECategory category;

    @NotNull
    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 200)
    private String email;

    @Override
    public String toString() {
        return String.format("ID:%6d, 이름:%s, 분류:%s, 번호:%s, 이메일:%s}", this.id, this.name, this.category, this.phoneNumber, this.email);
    }
}
