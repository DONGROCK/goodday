package com.ohgiraffers.api.section03.valid;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("valid")
public class ValidTestController {

    //예외처리 할 때 사용.
    @GetMapping("/users/{userNo}")
    public ResponseEntity<?> findUserByNo() throws UserNotFoundException {

        boolean check = true;
        if(check){
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
        }

        return ResponseEntity.ok().build();
    }

    //값을 검증
    @PostMapping("/users")
    public ResponseEntity<?> registUser(@Valid @RequestBody UserDTO user){
        System.out.println("user = " + user);


        return ResponseEntity.created(URI.create("/valid/users/")).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e){

        String code = "";
        String description = "";
        String detail = "";
        /* 에러가 났다면
        * error가 있다면*/
        if (e.getBindingResult().hasErrors()){
            detail = e.getBindingResult().getFieldError().getDefaultMessage();// e.getMessage()

            String bindResultCode = e.getBindingResult().getFieldError().getCode(); //NotNull, Null
            System.out.println("bindResultCode = " + bindResultCode);
            switch (bindResultCode){
                case "NotNull": //에러 이름자리?
                    code = "ERROR_CODE_0001";
                    description = "필수 값이 누락되었다.";

            }
        }

        ErrorResponse errorResponse = new ErrorResponse(code, description, detail);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);


    }

}
