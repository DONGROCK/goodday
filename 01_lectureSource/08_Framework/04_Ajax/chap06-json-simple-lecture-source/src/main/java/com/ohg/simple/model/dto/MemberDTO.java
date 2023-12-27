package com.ohg.simple.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class MemberDTO {

    private String code;
    private String firstName;
    private String lastName;
    private int age;
}
