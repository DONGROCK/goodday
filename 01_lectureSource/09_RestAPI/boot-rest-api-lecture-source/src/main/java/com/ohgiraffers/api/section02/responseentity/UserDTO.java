package com.ohgiraffers.api.section02.responseentity;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {
    private int no;
    private String id;
    private String pw;
    private String name;
    private Date enrollDate;

}
