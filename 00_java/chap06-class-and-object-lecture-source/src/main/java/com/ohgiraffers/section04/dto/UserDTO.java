package com.ohgiraffers.section04.dto;

import java.util.Date;

public class UserDTO {

    /*
    * 자바빈(Java Bean)이란..
    * JSP에서 배우게 될 표준 액션 태그로 접근할 수 있는 자바클래스이다.
    *
    * 자바 코드를 모르는 웹 퍼블리셔들도 자바 코드를 사용할 수 있도록 태그 형식으로 지원하는 문법을 의미하는데
    * 그 때 사용할 수 있도록 규칙을 지정해놓은 java클래스를 자바빈이라고 부룬다.
    *
    * 지금은 특정 목적에 따라 클래스를 작성하는 규칙이라고 보면된다.
    * */

    /*자바빈 작성 규칙
    * 1. 자바빈은 특정 패키지에 속해있어야 한다.(default 패키지사용금지)
    * 2. 맴버변수의 접근제어자는 private로 선언해야한다
    * 3. 기본생성자가 명시적을 존재해야 한다.(매개변수 있는 생성자는 선택사항)
    * 4. 모든 맴버변수에 접근 간으한 설정자(setter)와 접근자(getter)가 public 으로 작성되어 있어야 한다.
    * 5. 직렬화(Serializable 구현)가 되어야 한다. (선택사항)*/

    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /*기본 생성자 명시적으로 ㅈ가성
    * 매개변수 있는 생성자를 선택적으로 추가 할 수 있도록 기본생성자를 명시한다
    * (명시하지 않고 추후 매개변수있는 생성자를 추가할 시 에러 발생 가능성이 있기 떄문이다.)*/

    public UserDTO(){

    }

    public UserDTO(String id, String pwd, String name, Date enrollDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getInfomation(){
        return  "id = " + this.id +
                "\npwd = " + this.pwd +
                "\nname _ " + this.name +
                "\nenrollDate = " + this.enrollDate;
    }
}
