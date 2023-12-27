package com.ohgiraffers.receive.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ModelDTO {
    private String type;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "{\"type\":\"" + type + "\","
                + "\"firstName\":\"" + firstName + "\","
                + "\"lastName\":\"" + lastName + "\","
                + "\"age\":" + age + "}";
    }
}
