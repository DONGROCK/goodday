package com.ohgiraffers.api.section03.valid;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {
    private String code;
    private String desciption;
    private String detail;
}
