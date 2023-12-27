package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    /*다른 컨트롤러에서 Exception이 발생했을 때 는 ExceptionHandlerController에 정의한
    * @ExceptionHandler가 동작하지 않는다.
    * */

@GetMapping("other-controller-null")
    public String otherNullPointerException(){

    String str = null;

    System.out.println(str.charAt(0));

    return "/";
}
@GetMapping("other-controller-user")
    public String otherUserExceptionTest() throws MemberRegistException {

    boolean check = true;

    if(check){
        throw new MemberRegistException("당신은 못생겨서 회원으로 받을 수 없다..");

    }
    return "/";
}

@GetMapping("other-controller-array")
    public String otherArrayExceptionTest() throws MemberRegistException{

    double[] array = new double[0];
    System.out.println(array[0]);

    return "/";
}


}
