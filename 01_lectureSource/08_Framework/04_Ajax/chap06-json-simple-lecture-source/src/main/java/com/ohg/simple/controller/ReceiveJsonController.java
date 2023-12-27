package com.ohg.simple.controller;

import com.ohg.simple.model.dto.MemberDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/receive")
public class ReceiveJsonController {

    @GetMapping(value="simple")
    @ResponseBody
    public String getSimpleJsonTest(){
        MemberDTO member = new MemberDTO("M01","길동","홍",20);

        JSONObject json = new JSONObject();
        json.put("code",member.getCode());
        json.put("firstName",member.getFirstName());
        json.put("lastName",member.getLastName());
        json.put("age",member.getAge());

        System.out.println("json = " + json.toJSONString());
        return json.toJSONString();
    }

    @GetMapping(value = "array")
    @ResponseBody
    public String getArrayJsonTest(){
        MemberDTO member1 = new MemberDTO("M01", "길동", "홍", 20);
        MemberDTO member2 = new MemberDTO("M02", "순신", "이", 43);
        MemberDTO member3 = new MemberDTO("M03", "관순", "유", 16);
        MemberDTO member4 = new MemberDTO("M04", "봉길", "윤", 33);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);

        JSONArray jsonArray = new JSONArray();
        for(MemberDTO member : memberList){

            JSONObject json = new JSONObject();
            json.put("code",member.getCode());
            json.put("firstName",member.getFirstName());
            json.put("lastName",member.getLastName());
            json.put("age",member.getAge());

            jsonArray.add(json);
        }
        System.out.println("jsonArray = " + jsonArray.toJSONString());

        return jsonArray.toJSONString();

    }
}