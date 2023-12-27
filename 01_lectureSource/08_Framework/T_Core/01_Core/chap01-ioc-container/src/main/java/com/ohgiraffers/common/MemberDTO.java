package com.ohgiraffers.common;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private int sequence;

    private String id;

    private String pwd;

    private String name;
}
