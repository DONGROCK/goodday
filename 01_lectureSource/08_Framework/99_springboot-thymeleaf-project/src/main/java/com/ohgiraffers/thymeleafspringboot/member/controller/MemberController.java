package com.ohgiraffers.thymeleafspringboot.member.controller;

import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberModifyException;
import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberRemoveException;
import com.ohgiraffers.thymeleafspringboot.common.util.SessionUtil;
import com.ohgiraffers.thymeleafspringboot.member.model.dto.MemberDTO;
import com.ohgiraffers.thymeleafspringboot.member.model.service.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final PasswordEncoder passwordEncoder;
    private final MemberServiceImpl memberService;

    public MemberController(PasswordEncoder passwordEncoder, MemberServiceImpl memberService) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
    }

    @GetMapping("/regist")
    public String goRegister() {
        return "content/member/regist";
    }

    @PostMapping("/regist")
    public String registMember(@ModelAttribute MemberDTO member,
                               @RequestParam String zipCode,
                               @RequestParam String address1,
                               @RequestParam String address2,
                               RedirectAttributes rttr) throws MemberRegistException {

        log.info("");
        log.info("");
        log.info("[MemberController] registMember ========================================================== start");

        String address = zipCode + "$" + address1 + "$" + address2;
        member.setPhone(member.getPhone().replace("-", ""));
        member.setAddress(address);
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        log.info("[MemberController] registMember request Member : " + member);

        memberService.registMember(member);

        rttr.addFlashAttribute("message", "회원 가입에 성공하였습니다.");

        log.info("[MemberController] registMember ========================================================== end");

        return "redirect:/";
    }

    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO memberDto) {

        log.info("");
        log.info("");
        log.info("[MemberController] checkDuplication ========================================================== start");

        String result = "사용 가능한 아이디 입니다.";
        log.info("[MemberController] Request Check ID : " + memberDto.getMemberId());

        if("".equals(memberDto.getMemberId())) {
            log.info("[MemberController] No Input Member ID");
            result = "아이디를 입력해 주세요";
        } else if(memberService.selectMemberById(memberDto.getMemberId())) {
            log.info("[MemberController] Already Exist");
            result = "중복된 아이디가 존재합니다.";
        }

        log.info("[MemberController] checkDuplication ========================================================== end");

        return ResponseEntity.ok(result);
    }


    @GetMapping("/login")
    public String goLogin() {

        return "content/member/login";
    }


    @GetMapping("/loginfail")
    public String goLoginFail() {

        return "errors/login";
    }

    @GetMapping("/update")
    public String goModifyMember() {

        return "content/member/update";
    }

    @PostMapping("/update")
    public String modifyMember(@ModelAttribute MemberDTO member,
                               @RequestParam String zipCode,
                               @RequestParam String address1,
                               @RequestParam String address2,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               RedirectAttributes rttr) throws MemberModifyException {

        log.info("");
        log.info("");
        log.info("[MemberController] modifyMember ========================================================== start");

        String address = zipCode + "$" + address1 + "$" + address2;
        member.setPhone(member.getPhone().replace("-", ""));
        member.setAddress(address);
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        log.info("[MemberController] modifyMember request Member : " + member);

        memberService.modifyMember(member);

        // 회원정보 수정후 로그아웃 프로세스 진행
        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 정보 수정에 성공하셨습니다. 다시 로그인해주세요.");

        log.info("[MemberController] modifyMember ========================================================== end");

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteMember(@ModelAttribute MemberDTO member,
                               RedirectAttributes rttr,
                               HttpServletRequest request,
                               HttpServletResponse response) throws MemberRemoveException {

        log.info("");
        log.info("");
        log.info("[MemberController] deleteMember ========================================================== start");

        String memberId = request.getParameter("id");
        member.setMemberId(memberId);

        log.info("[MemberController] member : " + member);
        memberService.removeMember(member);

        // 회원 탈퇴후 로그아웃 프로세스 진행
        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 탈퇴에 성공하셨습니다. 로그아웃됩니다.");

        log.info("[MemberController] deleteMember ========================================================== end");

        return "redirect:/";
    }
}
