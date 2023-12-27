package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersnalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator(){

        return new PersnalAccount(20, "110-232-444312");

    }

    @Bean
    public MemberDTO memberGenerator(){
//        // MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴값을 전달하여 bean을 조립!!
//        return new MemberDTO(1, "홍길동", "010-2315-1742",
//                "ehdfkr8022@naver.com" , accountGenerator());
    MemberDTO member = new MemberDTO();
    member.setSequence(1);
    member.setName("동락");
    member.setPhone("01023151742");
    member.setEmail("ehdfkr8022@naver.com");
    //setter를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립 할 수 있따.
        //바꿔야할 때 accountGenerator()만 바꿔서 쓰면 된다.
    member.setPersonalAccount(accountGenerator());

    return member;
    }
}
