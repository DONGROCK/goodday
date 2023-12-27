package com.ohgiraffers.api.section01.response;

import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Message {
    private int httpStatusCode;
    private String message;
}
