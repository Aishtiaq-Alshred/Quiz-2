package com.example.quze.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    @NotEmpty(message = "your id is Empty!")
    private  String ID;

    @NotNull(message = "your number of page is Empty!")
    @Positive(message = "number of page must Positive number ")
    private int numberOfPages;

    @NotEmpty(message = "your name book is Empty!")
    private String name;

    @NotNull(message = "your price is Empty!")
    private double price;

   @Pattern(regexp = "(novel|academic)")
    private String category;

   //****
   @NotEmpty(message = "your ")
    private boolean isAvailable;
}
