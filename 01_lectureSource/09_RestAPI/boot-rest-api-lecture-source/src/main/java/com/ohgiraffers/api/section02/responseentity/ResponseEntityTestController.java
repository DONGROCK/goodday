package com.ohgiraffers.api.section02.responseentity;

import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/users/{userNo}") //{userNo} 는 PathVariable //{userNo}를 포함하지 않으면 404에러
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        //선택조회? 반복을 돌면서 해당객체를 찾는다.
        //스트림을 사용해서 필터처리 가능
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).collect(Collectors.toList()).get(0);

        System.out.println("foundUser = " + foundUser);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);

        return ResponseEntity.ok().headers(headers).body(new ResponseMessage(200,"조회 성공!", responseMap));

    }

    @PostMapping("/users")
    public ResponseEntity<?> registUser(@RequestBody UserDTO newUser){

        System.out.println("newUser = " + newUser);

        int lastUserNo = users.get(users.size() - 1).getNo(); // 맨 마지막 사용자의 No를 조회
        newUser.setNo(lastUserNo + 1);

        users.add(newUser);

        return ResponseEntity.created(URI.create("/entity/users/" + users.get(users.size() - 1).getNo()))
                .build();

    }

    @PutMapping("/users/{userNo}") //전체수정
    public ResponseEntity<?> modifyUser(@RequestBody UserDTO modifyInfo, @PathVariable int userNo){

        System.out.println("modifyInfo ============= " + modifyInfo);

        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).collect(Collectors.toList()).get(0);
        foundUser.setId(modifyInfo.getId());
        foundUser.setPw(modifyInfo.getPw());
        foundUser.setName(modifyInfo.getName());

        return ResponseEntity.created(URI.create("/entity/users/" + userNo)).build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<?> removeUser(@PathVariable int userNo){

        UserDTO foundUser =
                users.stream().filter(user -> user.getNo() == userNo).collect(Collectors.toList()).get(0);

        users.remove(foundUser);

        return ResponseEntity.noContent().build();

        /*
        * 자원 수정요청 결과가 기존의 자원 내용과 동일하여 변경된 내용이 없을 때는 상태코드값을 204로 응답할 수 있다.
        * 만약 수정 요청으로 자원의 내용이 변경된다면 201로 응답한다.
        *
        * DELETE도 삭제 요청으로 삭제를 하여 더이상 참조할 수 없기 때문에 204로 응답해야 하지만
        * 204로 응답하는 API는 거의 없다시피하여 대부분 200으로 응답한다.
        * */
    }
}
