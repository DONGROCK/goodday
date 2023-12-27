package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {

    public static void main(String[] args) {

        /*
        * 리플렉션이란?
        * 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법으로 반사, 투영 이라는 의미를 가진다.
        * 리플렉션은 JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다.
        * 스프링프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용한다.
        * Reflection을 사용해서 스프링에서는 런타임 시에 개발자가 등록한 빈을 애플리케이션 내에서 사용할 수 있게 하는 것이다.
        *
        * reflection은 강력한 도구이지만 무분별하게 사용해서는 안된다.
        * 주의사항
        * 1. 오버헤드 발생 : 성능 저하를 발생할 수 있기 때문에 성능에 민감한 애플리케이션에서는 사용하지 않는다.
        * 2. 캡슐화 저해 : private로 설정한 member에 접근 가능하기 때문에 코드 기능이 저하되며 여러 가지 문제를 발생 시킬 수 있다.
        * 참고 링크 : https://docs.oracle.com/javase/tutorial/reflect/
        * 리플렉션이 사용되는 경우
        * 1. IOC 컨테이너
        * 2. AOP
        * 3. 마이바티스 매퍼
        * 4. log4jdbc
        * */

        /*
        * .class 문법을 이용하여 Class 타입의 인스턴스를 생성할 수 있다.
        * Class타입의 인스턴스는 해당 클래스의 메타정보를 가지고 있는 클래스이다.
        * */
        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

        /* Class.forName() 메소드를 이용하여 런타임시 로딩을 하고 그 클래스 메타정보를 Class 타입으로 반환받을 수 있다.*/
        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            Class class5 = double[].class;

            System.out.println("class4 = " + class4);
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            Class class7 = String[].class;

            System.out.println("class6 = " + class6);
            System.out.println("class7 = " + class7);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 원시 자료형을 사용하면 컴파일 에러 발생
//        double d = 1.0;
//        Class class8 = d.getClass();

        /* TYPE 필드를 이용하여 원시형 클래스를 반환받을 수 있다. */
        Class class8 = Double.TYPE;
        System.out.println("class8 = " + class8);

        Class class9 = Void.TYPE;
        System.out.println("class9 = " + class9);

        Class supperClass = class1.getSuperclass();
        System.out.println("supperClass = " + supperClass);

        /*필드정보를 반환한다*/
        Field[] fields = Account.class.getDeclaredFields();
        for(Field field : fields){
            System.out.println("modifiers : " + Modifier.toString(field.getModifiers())
                    +", type : " + field.getType()
                    +", name : " + field.getName()

            );
        }

        Constructor[] constructors =Account.class.getConstructors();
        for (Constructor con : constructors){
            System.out.println("name = " + con.getName());

            Class[] params = con.getParameterTypes();
            for (Class param : params){
                System.out.println("paramType : " + param.getTypeName());
            }
        }

        /*생성자를 이용하여 인스턴스를 생성할 수 있다.*/


        try {
            Account acc = (Account) constructors[0].newInstance("20","110-112-123132","1234",100000);
            System.out.println(acc.getBalance());

        } catch (InstantiationException |IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        /*메소드 정보에 접근할 수 있다.*/
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;

        for (Method method: methods){
            System.out.println(Modifier.toString(method.getModifiers())
                + " " + method.getReturnType().getSimpleName()
                    + " " + method.getName()
            );

            if ("getBalance".equals(method.getName())){
                getBalanceMethod = method;
            }
        }

        try {
            System.out.println(getBalanceMethod.invoke((Account)constructors[2].newInstance()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
