package com.greedy.level1.basic.member.run;

import com.greedy.level1.basic.member.model.dto.MemberDTO;

public class Application {
    public static void main(String[] args) {
        MemberDTO member = new MemberDTO();

        System.out.println("id : " + member.getId());
        System.out.println("pwd : " + member.getPwd());
        System.out.println("name : " + member.getName());
        System.out.println("age : " + member.getAge());
        System.out.println("gender : " + member.getGender());
        System.out.println("phone : " + member.getPhone());
        System.out.println("email : " + member.getEmail());

        member.setId("id1234");
        member.setPwd("pw1234");
        member.setName("name1234");
        member.setAge(26);
        member.setGender('M');
        member.setPhone("010-0101-0101");
        member.setEmail("email1234@email.com");

        System.out.println("========변경후========");

        System.out.println("변경 후 id : " + member.getId());
        System.out.println("변경 후 pwd : " + member.getPwd());
        System.out.println("변경 후 name : " + member.getName());
        System.out.println("변경 후 age : " + member.getAge());
        System.out.println("변경 후 gender : " + member.getGender());
        System.out.println("변경 후 phone : " + member.getPhone());
        System.out.println("변경 후 email : " + member.getEmail());
    }
}
