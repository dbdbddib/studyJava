package com.example.myjpa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneBookRequest implements IPhoneBook {
    private Long id;

    @NotBlank
    @Size(min = 2, max = 13)
    private String name;

    @NotBlank
    @Size(min = 4, max = 8)
    private String category;

    @Size(min = 0, max = 20)
    private String phoneNumber;

    @Size(min = 0, max = 200)
    private String email;
}
