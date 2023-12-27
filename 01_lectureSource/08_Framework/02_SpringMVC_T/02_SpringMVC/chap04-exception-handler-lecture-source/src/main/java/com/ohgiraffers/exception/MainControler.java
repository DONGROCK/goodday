package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControler {

    @RequestMapping(value = {"/", "main"})
    public String main() {
        return "main";
    }
}
