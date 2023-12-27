package com.ohgiraffers.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/first")
public class FirstAjaxController {

    @GetMapping(value = "receive", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String getReceiveTest(){
        /*
        * 응답하는 데이터가 단순 문자열일 경우 문자열만 내보낼 수 있따.
        * 이 떄 기본 응답데이터는 text/plain이다.
        * */

        String output = "Im get insert value !! 안녕스";

        return output;
    }
}
