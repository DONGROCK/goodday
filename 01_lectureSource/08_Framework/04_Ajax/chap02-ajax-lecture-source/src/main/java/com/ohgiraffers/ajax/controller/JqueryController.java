package com.ohgiraffers.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JqueryController {

    @GetMapping(value = "jquery", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String jqueryTest(@RequestParam String name){

        String output = name + "님 환영합니다.";

        System.out.println("output = " + output);

        return output;
    }
}
