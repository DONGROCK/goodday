package com.ohgiraffers.api.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* @Controller와 @ResponseBody 어노테이션을 합친 어노테이션이다.
* 클래스 레벨에 작성하며 해당 클래스 내모든 핸들러 메소드에 @ResponseBody 어노테이션을 묵시적으로 적용한다.
* */
@RestController //이게 오늘핵심
@RequestMapping("/response")
public class ResponseRestController {

    /*1.문자열 응답*/
    @GetMapping("hello")
    public String helloworld(){//문자열
        return "hello world!";
    }

    /*2. 기본자료형 응답*/
    @GetMapping("/random")
    public int getRandomNumber(){//정수형

        return (int)(Math.random() * 10) + 1;
    }
    /*3. Object응답*/
    @GetMapping("/message")
    public Message getMessage(){

        return new Message(200, "메시지 응답");


    }

    /*4. List응답*/
    @GetMapping("/list")
    public List<String> getList(){

        /*
        * List.of는 java 9버전부터 지원하는 메소드
        *   배열을 List로 변환하기 위해서 사용(생성된 객체는 변경 불가하다.) // 불변객체
        *
        * Arrays.asList()로도 동일하게 변경을 하는데 요건 변경가능 // 불변객체가 아니다.
        * */
        return List.of(new String[] {"사과","바나나","복숭아"});
    }

    /*5. Map응답*/
    @GetMapping("/map")
    public Map<Integer, String> getMap(){

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "정상응답"));
        messageList.add(new Message(404, "페이지를 찾을 수 없다."));
        messageList.add(new Message(500, "개발자의 잘못입니다."));

        return messageList.stream().collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    /*6. ImageFile 응답
    * producess 설정을 안해주면 text/plain 마인타입 으로 응답하기 때문에 텍스트 형태로 전송된다.
      producess는 response hender의 content-type 설정이다.
      * 우리는 지금 이미지를 가져와야 하니까 설정해줘야함/
     */
    @GetMapping(value = "image", produces = MediaType.IMAGE_PNG_VALUE) //?? 미디어타입 이미지 벨류??
    public byte[] getImage() throws IOException {

        return getClass().getResourceAsStream("/images/sample.PNG").readAllBytes();
        // getClass().getResourceAsStream("/images/sample.PNG").readAllBytes(); ??

    }

    /*
    * 7. ResponseEntity를 이용한 응답         ResponseEntity???
    * */
@GetMapping("/entity")
    public ResponseEntity<Message> getEntity(){

        return ResponseEntity.ok(new Message(123, "helloworld"));
//        return ResponseEntity.ok(new Message(123, "helloworld")); ???
    }




//    @GetMapping(value = "list", produces = "applicaion/json; charset=utf-8")
//    @RequestBody
//    public String testMethod(){
//        return "response/list";
//    }

//    @PostMapping(value = "member") //텍스트로 보낼 때는 produces X
//    @ResponseBody
//    public String postMethod(){
//        return "insert success";
//    }
}
