package com.ohg.security.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*기본 index 페이지에서 요청한 값을 기준으로 페이지 이동*/
@Controller
public class IndexController {

    /*
    * 기본 요청 시 페이지 이동을 위한 메소드
    * */
    @GetMapping
    public String root(){
        return "index";
    }


    /*
    * 관리자 권한 설정 페크를 위한 메소드
    * */
    @GetMapping("/admin/page")
    public String admin(){
        return "admin/admin";
    }

    /*
    * 유저 권한 설정 체크를 위한 메소드
    * */
    @GetMapping("user/page")
    public String user(){
        return "user/user";
    }


}
