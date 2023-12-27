package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// DispatcherServlet은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
// 그과정은 컨트롤러 클래스의 핸들러 메서드에 선언된 다양한 @RequestMapping 설정 내용에 따른다.
@Controller
public class MethodMappingTestController {

    /*1. 메소드 방식을 미지정
    * */
    @RequestMapping("/menu/regist")
    public String registMenu(Model model){

        System.out.println("+++++++++++++요청확인+++++++++++++");
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함");

        //반환하고자 하는 view의 경로를 포함한 이름을 작성
        //resources/templates 하위부터의 경로를 작성

        return "mappingResult";
    }
    //2. 메소드 방식지정
    //요청 URL을 value속성에 요청 method를 method 속성에 설정
    @RequestMapping(value = "/menu/modify" , method = RequestMethod.GET)
    public String modifyMenu(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출함..");

            return "mappingResult";
        }

        //3, 요청 메소드 전용 어노테이션
    //요청메소드         어노테이션
    //POST              @PostMapping
    //GET               @GetMapping
    //PUT               @PutMapping         //전체업데이트
    //DELETE            @DeleteMapping
    //PATCH             @PatchMapping       //일부수정
    //이 어노테이션들은 @RequestMapping 어노테이션에 method속성을 사용하여 요청방법을 지정하는 것과 동일하다.
    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model){

        model.addAttribute("message", "GET방식의 삭제용 핸들러 메소드 호출함..");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model){
        model.addAttribute("message", "POST 방식의 삭제용 핸들러 메소드 호출함..");

        return "mappingResult";
    }



    }

