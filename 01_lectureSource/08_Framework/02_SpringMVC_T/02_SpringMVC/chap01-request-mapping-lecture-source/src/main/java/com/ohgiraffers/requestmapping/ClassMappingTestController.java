package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
* 클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다.
* 클래스레벨에 URL을 공통 부분을 이용해 설저하고 나면 매번 핸들러 메소드에 URL의 중복되는 내용을 작성하지 않아도 된다.
* 이 때 와일드카드를 이용해서 조금더 포괄적인 URL패턴을 설정할 수 있다.
* */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    /*1. Class 레벨 매핑*/
    @GetMapping("/regist")
    public String registOrder(Model model) {

        model.addAttribute("message", "GET방식의 주문 등록용 핸들러 메소드 호출함..");

        return "mappingResult";
    }

    /* 2. 여러 개의 패턴 매핑 */
    @RequestMapping(value={"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {

        model.addAttribute("message"
                , "POST방식의 주문 정보 수정과 주문정보 삭제 공통 처리용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    // http://localhost:8080/menu?id=1&no=10  http://localhost:8080/1/menu/10
    /*
    * 3. path variable
    *   @PathVariable 어노테이션을 이용해 요청 path로부터 변수를 받아올 수 있다.
    *   Path variable로 전달되는 {변수명} 값은 반드시 매개변수명과 동일해야한다.
    *   만약 동일하지 않으면 @PathVariable("이름")을 설정해 주어야 한다.
    *   --> 이는 REST형 웹 서비스를 설계할 때 유용하게 사용된다.
    * */
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int no) {
        /*
        * parsing 불가능한 PathVariable이 전달되면 400번 에러가 발생한다.
        * PathVariable이 없으면 해당 핸들러 메소드를 찾지 못해서 404번 에러가 발생한다.
        * */
        System.out.println("orderNo = " + no);
        model.addAttribute("message", no + "번 주문 상세 내용 조회용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    /* 4. 그 외의 다른 요청 */
    /* @RequestMapping 어노테이션에 아무런 URL을 설정하지 않으면 요청 처리에 대한 핸들러 메소드가 준비되지 않았을 때 해당 메소드를
    * 요청한다.
    * */
    @RequestMapping
    public String otherRequest(Model model){

        model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비되지 않음...");

        return "mappingResult";
    }
}
