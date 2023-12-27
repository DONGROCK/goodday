package com.ohg.security.user.model.dto;


import lombok.*;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SingUpDTO {

    private String userId;
    private String userName;
    private String userPass;
    private String role;
}
