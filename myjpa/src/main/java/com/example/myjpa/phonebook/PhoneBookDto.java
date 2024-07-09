package com.example.myjpa.phonebook;

import lombok.*;

import com.example.myjpa.category.ICategory;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PhoneBookDto implements IPhoneBook {
    private Long id;
    private String name;
    private ICategory category;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return String.format("ID:%6d, 이름:%s, 분류:%s, 번호:%s, 이메일:%s}"
                , this.id, this.name
                , (this.category.getName() != null) ? this.category.getName() : "null"
                , this.phoneNumber, this.email);
    }
}
