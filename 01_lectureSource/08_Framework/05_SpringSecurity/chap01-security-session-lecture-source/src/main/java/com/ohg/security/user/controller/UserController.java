package com.ohg.security.user.controller;

import com.ohg.security.user.model.dto.SingUpDTO;
import com.ohg.security.user.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

private MemberService memberService;

    public UserController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("singup")
    public void singupPage(){}

    @PostMapping("member")
    public ModelAndView singup(@ModelAttribute SingUpDTO singUpDTO, ModelAndView mv){

        System.out.println("singUpDTO = " + singUpDTO);

        int result = memberService.regist(singUpDTO);

        String message;
        if (result > 0){
            message = "회원가입이 완료되었습니다.";
            mv.setViewName("auth/login");
        } else{
            message = "회원가입이 실패되었습니다.";
            mv.setViewName("singup");
        }

        mv.addObject("message", message);

        return mv;
    }
}
