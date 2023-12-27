package com.ohgiraffers.api.section02.responseentity;

import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.*;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {
    /*ResponseEntity란
     * 결과 데이터와 http상태 코드를 직접 제어할 수 있는 클래스이다.
     * HttpStatus, HttpHenaders, HttpBody를 포함한다.
     * */

    private List<UserDTO> users;
    public ResponseEntityTestController(){
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01","pass01","빼빼로",new Date()));
        users.add(new UserDTO(2, "user02","pass02","홈런볼",new Date()));
        users.add(new UserDTO(3, "user03","pass03","맛동산",new Date()));
    }

    @GetMapping("users")
    public ResponseEntity<ResponseMessage> findAllUsers(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));????

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회성공",responseMap);
        return new ResponseEntity<>(responseMessage,headers, HttpStatus.OK);
//        return new ResponseEntity<>(responseMessage,headers, HttpStatus.OK); ???
    }
}
