package com.ohgiraffers.section04.wrapper;

public class Application2 {
    public static void main(String[] args) {
        /*문자열 파싱(parsing)
        * 문자열(String)값을 기본자료형 값으로 변경하는 것을 parsing이라고 한다.
        * */
        byte b = Byte.parseByte("1");
        Short s = Short.parseShort("2");
        int i = Integer.parseInt("3");
        long l = Long.parseLong("8"); //8l은 안된다.
        float f = Float.parseFloat("4.0f");//4.0f는 된다.
        double d = Double.parseDouble("8.0");
        boolean bl = Boolean.parseBoolean("true");

        /*Character는 parsing 기능을 제공하지 않는다..*/
        char c = "abc".charAt(0);
        System.out.println(f);
    }
}
