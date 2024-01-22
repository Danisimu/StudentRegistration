package com.example.StudentsRegistration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private int age;

    @Override
    public String toString() {
        return "ID: " + id
                + " Имя: "  + firstName
                + " Фамилия: " + lastName
                + " Возраст: " + age;
    }
}
