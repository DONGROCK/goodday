package com.ohg.gson.controller;

import com.google.gson.Gson;
import com.ohg.gson.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/gson")
public class GsonController {

    @GetMapping(value="test1")
    @ResponseBody
    public String gsonTest1(){

        MemberDTO member = new MemberDTO("M01","길동","홍",20, new Date(System.currentTimeMillis()));
        Gson gson = new Gson();
        //toJson()으로 json 문자열로 변경한다.
        String jsonString = gson.toJson(member);
        System.out.println("jsonString = " + jsonString);

        //json문자열
        //json문자열을 다시 Object로 변경
        MemberDTO jsonMember = gson.fromJson(jsonString,MemberDTO.class);
        System.out.println("jsonMember = " + jsonMember);

        return jsonString;
    }

    @GetMapping(value = "test2", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String gsonTest2(@ModelAttribute MemberDTO member){

        System.out.println(member);

    String jsonString = new Gson().toJson(member);

        System.out.println("jsonString = " + jsonString);


        return jsonString;
    }

    @GetMapping(value = "test3", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String gsonTest3(@ModelAttribute MemberDTO member){

        System.out.println(member);

        String jsonString = new Gson().toJson(member);

        System.out.println("jsonString = " + jsonString);


        return jsonString;
    }


    @GetMapping(value = "test4", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String gsonTest4(@RequestParam String jsonString){
        
        /*view에서 전달받은 날짜는 2023-11-30 형태로 전송*/
        System.out.println("jsonString = " + jsonString);
        
        Gson gson = new Gson();
        
        String dataTest = gson.toJson(new Date(System.currentTimeMillis()));
        System.out.println("dataTest = " + dataTest);
        
        return "";
    }


}