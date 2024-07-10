package com.example.myjpa.phonebook;

import com.example.myjpa.category.CategoryDto;
import com.example.myjpa.category.CategoryEntity;
import com.example.myjpa.category.ICategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder

// Conrtollor 에서 객체 생성하여 JSON 교류하는?

public class PhoneBookRequest implements IPhoneBook {
    @JsonIgnore
    private Long id;

    @NotBlank       // 공백과 null이 아닌지 검사
    @Size(min = 2, max = 12)
    private String name;

    @NotBlank
    private CategoryDto category;

    @NotBlank
    @Size(min = 0, max = 20)
    private String phoneNumber;

    @NotBlank
    @Size(min = 0, max = 200)
    private String email;

    @Override
    public void setCategory(ICategory category) {
        if (category == null) {
            return;
        }
        CategoryDto entity = new CategoryDto();
        entity.copyFields(category);
        this.category = entity;
    }
}
