package com.example.quze.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Valid
@AllArgsConstructor
@Data
public class UserClass {
    @NotEmpty(message = "your id is Empty!")
    private String id;

    @NotEmpty(message = "your name is Empty!")
    private String name;

    @NotNull(message = "your age is Empty!")
    private int age;

    @NotNull(message = "your balance  is Empty!")
    private int balance;

    @NotEmpty(message = "your role is Empty!")
    @Pattern(regexp = ("customer|libraian"))
    private String role;
}
