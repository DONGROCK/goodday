package com.ohgiraffers.receive.controller;

import com.ohgiraffers.receive.model.dto.ModelDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.memberList;

@Controller
@RequestMapping("/receive")
public class ReceiveController {

    /*1. override 이용하여 json 문자열 응답 */
    @GetMapping(value = "override", produces = "application/json; charset=UTF-8")
@ResponseBody
    public String getOverrideTest(){
        ModelDTO member = new ModelDTO("get","gildong", "hong", 200);
        System.out.println("member = " + member);

        return member.toString();
    }

    /*2. list객체 json 문자열로 응답*/
    @GetMapping(value = "list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getListTest(){

        ModelDTO member1 = new ModelDTO("get", "gildong", "hong", 20);
        ModelDTO member2 = new ModelDTO("get", "soonsin", "lee", 43);
        ModelDTO member3 = new ModelDTO("get", "gwansoon", "yoo", 16);
        ModelDTO member4 = new ModelDTO("get", "bonggil", "yoon", 33);

        List<ModelDTO> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);

        System.out.println("memberList = " + memberList);

        return memberList.toString();
    }

    /*3. Map객체 json문자열로 응답*/
    @GetMapping(value = "map" , produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getMapTest(){

        ModelDTO member1 = new ModelDTO("get", "gildong", "hong", 20);
        ModelDTO member2 = new ModelDTO("get", "soonsin", "lee", 43);
        ModelDTO member3 = new ModelDTO("get", "gwansoon", "yoo", 16);
        ModelDTO member4 = new ModelDTO("get", "bonggil", "yoon", 33);

        Map<String, ModelDTO> memberMap = new HashMap<>();
        memberMap.put("one",member1);
        memberMap.put("two",member2);
        memberMap.put("three",member3);
        memberMap.put("four",member4);

        System.out.println("memberMap = " + memberMap);

        return "";
    }
}
