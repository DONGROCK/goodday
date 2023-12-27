package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleTestController {

    @GetMapping("/test/page")
    public String redirectPage(){
        //
        System.out.println("들어오니?");
        return "ResultPage";
    }
}
