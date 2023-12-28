package com.ohgiraffers.api.section03.valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {


    private int no;
    @NotNull(message = "아이디는 반드시 입력해야한다.") //해당 에러 메시지 출력
//    @NotBlank(message = "아이디는 공백일 수 없다.")// 중복적용 가능
    private String id;
    private String pw;
    @NotNull(message = "이름은 반드시 입력되어야 한다.")
    @Size(min=2, message = "이름은 2글자 이상 입력해야 한다.")
    private String name;
    @Past
    private Date enrollDate;
}
