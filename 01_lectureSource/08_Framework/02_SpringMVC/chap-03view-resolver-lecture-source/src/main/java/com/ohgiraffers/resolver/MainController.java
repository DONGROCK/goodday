package com.ohgiraffers.resolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/","/main"})  //localhost8080/ or localhost8080/main 일시
    public String main(){
        return "main";
    }
}
