package com.ohg.gson.model.dto;

//import java.util.Date;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private String code;
    private String firstName;
    private String lastName;
    private int age;
    private Date enrollDate;
}
