package com.ohgiraffers.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JavaScriptAjaxController {
    /*
        스프링에서 비동기 처리를 할 때는 @GetMapping,@PostMapping...과 같은 어노테이션의 속성값중에
        produces 속성에 MIME타입과 인코딩을 기술해야한다.
        또한 @ResponseBody어노테이션도 붙여줘야지 리턴값을 뷰리졸버가 페이지 이동으로 인식하지않고
        요청한 함수로 다시 응답을 해준다.
     */
    @GetMapping(value = "/test/javascript", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String responseText(@RequestParam String name) {

        String output = name + "님 환영합니다.";

        System.out.println("output = " + output);

        return output;
    }
}
