package com.ohgiraffers.json.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/receive")
public class ReceiveJsonController {
    /*
    * ajax 응답은 단 한번의 문자열 응답만 할 수 있따.
    *
    * java 에서 이용하는 object는 javascript에서 이해할 수 없다.
    * 따라서 자바스크립트에서 이해할 수 있는 object타입으로 변환을 해줘야 한다.
    * 이 때 json이라는 object타입으로 변환 할 수 있는 문자열 형태로 가공하여 응답하면
    * javascript에서 object로 취급할 수 있다.
    *
    * json 데이터의 규칙은 key와 value를 : 으로 구분하며, 여러 개 key value set은 , 로 구분한다.
    * key는 문자열 형태 ""로 감싸져야 하며, 문자열에 해당하는 값 또한 ""로 감싸져야 한다.
    * */

    /*1, json 문자열 */
    @GetMapping(value = "json", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String getJsonStringTest(){

        String output = "{\"type\":\"get\", \"firstname\":\"gildong\", \"lastname\":\"hong\",\"age\":20}";

        return output;
    }

    /*2. Jsonarray 문자열*/
    @GetMapping(value = "array", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String getArrayJsonStringTest(){

        String output = "[{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
                + "{\"type\":\"get\",\"firstname\":\"gwansoon\",\"lastname\":\"yoo\",\"age\":16},"
                + "{\"type\":\"get\",\"firstname\":\"soonsin\",\"lastname\":\"lee\",\"age\":40},"
                + "{\"type\":\"get\",\"firstname\":\"bonggil\",\"lastname\":\"yoon\",\"age\":34}]";

        return output;
    }

    /*JsonArray Json 객체*/
    @GetMapping(value = "jsonarray", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getArrayJsonArrayTest(){

        String output = "[{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
                + "{\"type\":\"get\",\"firstname\":\"gwansoon\",\"lastname\":\"yoo\",\"age\":16},"
                + "{\"type\":\"get\",\"firstname\":\"soonsin\",\"lastname\":\"lee\",\"age\":40},"
                + "{\"type\":\"get\",\"firstname\":\"bonggil\",\"lastname\":\"yoon\",\"age\":34}]";

        return output;
    }
}
