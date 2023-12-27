package com.ohgiraffers.section02.string;

public class Application1 {

    /*String 클래스에서 자주 사용하는 메소드 확인
    *
    * charAt(int index) : 해당 문자열의 특정 인덱스에 해당하는 문자를 반환한다.
    * 인덱스는 0부터 시작하는 숫자 채게를 의미하며
    * 인덱스를 벗어난 정수를 인자로 전달하는 경우에는 IndexOutOfBoundsException이 발생한다.
    *
    * */

    public static void main(String[] args) {
        String str1 = "apple";

        for(int i = 0; i < str1.length();i++){
            System.out.println("charAt("+ i + ") : " + str1.charAt(i));
        }
        /*compareTo() : 인자로 전달된 문자열과 사전 순으로 비교를 하여
        * 두 문자열이 같다면 0을 변환,
        * 인자로 전달된 문자열보다 작으면 음수를
        * 크면 양수를 반환한다
        * 단, 이 메소드는 대소문자를 구분하여 비교한다.
        * */
        String str2 = "java";
        String str3 = "java";
        String str4 = "JAVA";
        String str5 = "oracle";

        System.out.println("compareTO() : " + (str2.compareTo(str3)));

        System.out.println("compareTO() : " + (str2.compareTo(str4)));
        System.out.println("compareTO() : " + (str4.compareTo(str2)));
        // j 부터 o 까지 5만큼 차이
        System.out.println("compareTO() : " + (str2.compareTo(str5)));
        System.out.println("compareTO() : " + (str5.compareTo(str2)));

        System.out.println("compareToIgnoreCase() : " + (str3.compareToIgnoreCase(str4)));

        /*
        * concat(): 문자열에 인자로 전달된 문자열을 합치기해서 새로운 문자열을 반환한다.
        * 원본 문자열에는 영향을 주지 않는다.
        * */
        System.out.println("concat() : " + (str2.concat(str5)));
        System.out.println("str 2 : " + str2);

        /*
        * indexOf(): 문자열에서 특정 문자를 탐색하여 처음 일치하는 인덱스 위치를 정수형으로 반환한다.
        * 단, 일치하는 문자가 없는 경우 -1을 반환한다.
        * */

        String indexOf = "java oracle";
        System.out.println("indexOf('o') : " + indexOf.indexOf('o'));
        System.out.println("indexOf('z') : " + indexOf.indexOf('z'));

        /*
        * lastIndexOf() : 문자열 탐색을 뒤에서부터 하고 처음 일치하는 위치의 인덱스를 반환
        * 단, 일치하는 문자가 없는 경우 -1 반환
        * 뒤부터 탐색을 하든 앞에서 탐색을 하든 결과값은 왼쪽기준으로 나옴.
        * */
        System.out.println("lastIndexOf('a') : " + indexOf.lastIndexOf('a'));//7
        System.out.println("lastIndexOf('z') : " + indexOf.lastIndexOf('z'));//-1 일치값없음

        /*trim() : 문자열의 앞 뒤에 공백을 제거한 문자열을 반환한다.*/
        String trimStr = "   java   ";
        System.out.println("trimStr : #" + trimStr + "#");
        System.out.println("trimStr : #" + trimStr.trim() + "#");
        /*원본에 영향을 주지 않는다.*/
        System.out.println("trimStr : #" + trimStr + "#");

        /*toLowerCase() : 모든 문자를 소문자로 변환시킨다.
        * toUpperCase() : 모든 문자를 대문자로 변환시킨따!
        * */
        String caseStr = "JavaOracle";

        /*원본에 영향을 주지 않는다.*/
        System.out.println("toLowerCase() : " + caseStr.toLowerCase());
        System.out.println("toUpperCase() : " + caseStr.toUpperCase());

        System.out.println(caseStr);

        /*
        * substring() : 문자열의 일부분을 잘라내어 새로운 문자열을 반환한다.
        * 원본에 영향을 주지 않는다.
        * */
        String javaoracle = "javaoracle";
        //시작인덱스 이상 종료인덱스 미만
        System.out.println("substring(3, 6) : " + javaoracle.substring(3, 6));
        //하나만넣으면 시작인덱스 이상부터 출력
        System.out.println("substring(3) : " + javaoracle.substring(3));

        System.out.println("javaoracle : " + javaoracle);

        /*
        * replace() : 문자열에서 대처할 문자열로 기존 문자열을 변경해서 반환한다.
        * 원본에 영향을 주지 않는다.
        * */
        System.out.println("replace() : " + javaoracle.replace("java","phyton"));
        System.out.println("javaoracle : " + javaoracle);

        /*length() : 문자열의 길이를 정수형으로 반환한다.*/
        System.out.println("length() : " + javaoracle.length());
        System.out.println("빈 문자열의 길이 : " + ("".length()));

        /*
        * isEmpty() : 문자열의 길이가 0이면 true 를 반환, 아니면 false를 반환
        * 길이가 0인 문자열 null과는 다르다.
        * */
        System.out.println("isEmpty() : " + "".isEmpty()); //비어있으면 true
        System.out.println("isEmpty() : " + "악".isEmpty()); //비어있지 않으면 false
    }
}
