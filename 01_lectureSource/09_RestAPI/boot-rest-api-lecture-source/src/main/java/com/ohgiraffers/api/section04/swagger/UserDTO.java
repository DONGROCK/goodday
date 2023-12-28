package com.ohgiraffers.api.section04.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Schema(description = "사용자관련 DTO")//모델에 대한 설명을 적어주는 어노테이션
public class UserDTO {
    @Schema(description = "번호")
    private int no;
    @Schema(description = "아이디")
    private String id;
    @Schema(description = "비밀번호")
    private String pw;
    @Schema(description = "이름")
    private String name;
    @Schema(description = "입사일")
    private Date enrollDate;

}
