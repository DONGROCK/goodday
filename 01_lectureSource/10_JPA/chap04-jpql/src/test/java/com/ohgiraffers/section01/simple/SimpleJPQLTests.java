package com.ohgiraffers.section01.simple;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.awt.desktop.QuitEvent;
import java.util.List;

public class SimpleJPQLTests {

    /*
    * JPQL(Java Persistence Query Language)
    * JPQL은 엔티티 객체를 중심으로 개발할 수 있는 객체지향 쿼리이다.
    *
    * SQL보다 간결하며 특정 DBMS에 의존하지 않는다.
    * 방언을 통해 해당 DBMS에 맞는 SQL을 실행하게 된다.
    * JPQL은 find()메소드를 통한 조회와 다르게 항상 데이터베이스에 SQL을 실행해서 결과를 조회한다.
    * */

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpaTest");
    }

    @BeforeEach
    public void initManager(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory(){
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager(){
        entityManager.close();
    }

    /*JPQL의 기본 문법
    * SELECT, UPDATE, DELETE 등의 키워드 사용은 SQL과 동일하다.
    * INSERT는 persist() 메소드를 사용하면 된다.
    * 키워드는 대소문자를 구분하지 않지만, 엔티티의 속성은 대소문자를 구분하니 유의한다.
    * 엔티티 별칭을 필수도 사용해야 하며 별칭없이 작성하면 에러가 발생한다.
    * */

    /*
    * JPQL 사용 방법은 다음과 같다.
    * 1. 작성한 JPQL(문자열)을 entityManager.createQuery()메소드를 통해 쿼리 객체로 만든다.
    * 2. 쿼리 객체는 TypedQuery, query 두 가지가 있다.
    *   1. TypedQuery : 반환할 타입을 명확하게 지정하는 방식일 때 사용하며
    *       쿼리 객체의 메소드 실행 결과로 지정한 타입이 반환돤다.
    *   2. Query : 반환할 타입을 명확하게 지정할  수 없을 때 사용하며
    *       쿼리 객체 메소드의 실행 결과로 Object또는 Object[]이 반환된다.
    *
    * 3. 쿼리 객체에서 제공하는 메소드 getSingleResult() 또는 getResultList()를
    *       호출해서 쿼리를 실행하고 데이터베이스를 조회한다.
    *   1. getSingleResult() : 결과가 정확히 한 행일 경우 사용하며 없거나 많으면 예외가 발생한다.
    *   2. getResultList() : 결과가 2행 이상일 경우 사용하며 컬렉션을 반환한다.
    *                            결과가 없으면 빈 컬렉션을 반환한다.
    * */
    @DisplayName("TypedQuery를 이용한 단일메뉴 조회 테스트")
    @Test
    public void typedQuerySingleMenuTests(){

        //given
        String jpql = "SELECT m.menuName FROM menu_section01 as m WHERE m.menuCode = 7";
        //when
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();
        //then
        System.out.println("resultMenuName = " + resultMenuName);
    }

    @DisplayName("Query를 이용한 단일메뉴 조회 테스트")
    @Test
    public void querySingleMenuTest(){

        //given
        String jpql = "SELECT m.menuName FROM menu_section01 as m WHERE m.menuCode = 7";
        
        //when
        Query query = entityManager.createQuery(jpql); //결과 값의 타입을 명시하지 않음
        Object resultMenuName = query.getSingleResult(); //그래서 오브젝트
        //then
        Assertions.assertTrue(resultMenuName instanceof String);
        Assertions.assertEquals("열무김치라떼", resultMenuName);

    }
    @DisplayName("TypedQuery 를 이용한 단일행 조회 테스트")
    @Test
    public void typedquerySingleRowTest(){
        
        //given
        String jpql = "SELECT m FROM menu_section01 as m WHERE m.menuCode = 7";//별칭으로 행조회
        //when
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);//타입을 넣는 방식 알아둬
        Menu foundMenu = query.getSingleResult();
        //then
        Assertions.assertEquals(7, foundMenu.getMenuCode());
        System.out.println("foundMenu = " + foundMenu);
    }

    @DisplayName("TypeQuery를 이용한 다중행 조회 테스트")
    @Test
    public void TypedQueryListTest(){

        String jpql = "SELECT m FROM menu_section01 as m";

        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> foundMenuList = query.getResultList(); //getList니까 타입이 List<Menu>로

        Assertions.assertNotNull(foundMenuList);
        foundMenuList.forEach(System.out::println); //리스트니까 반복을 돌려
    }

    @DisplayName("Query를 이용한 다중행 조회 테스트")
    @Test
    public void QueryListTest(){

        String jpql = "SELECT m FROM menu_section01 as m";

        Query query = entityManager.createQuery(jpql);
        List<Menu> foundMenuList = query.getResultList(); //List는 모든 타입을 다 받아준다. 그러면 꺼낼때 (인스턴스오브?)를 사용해서 꺼내야하기 때문 넣을 때 제네릭을 통해 정리

        Assertions.assertNotNull(foundMenuList);
        foundMenuList.forEach(System.out::println); //리스트니까 반복을 돌려
    }

    /*연산자는 SQL과 다르지 않으므로 몇가지 종류의 연산자만 테스트를 진행*/

    @DisplayName("distinct를 활용한 중복제거 여러 행 조회 테스트")
    @Test
    public void distinctListTests(){

        //given
        String jpql = "SELECT DISTINCT m.categoryCode FROM menu_section01 m";//카테고리코드를 중복되지않게 조회
        //when
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> categoryCodeList = query.getResultList();
        //then
        Assertions.assertNotNull(categoryCodeList);
        categoryCodeList.forEach(System.out::println);
    }

    @DisplayName("in 연산자를 활용한 조회 테스트")
    @Test
    public void inoperatorTest(){
        //given
        String jpql = "SELECT m FROM menu_section01 m WHERE m.categoryCode IN (5, 7)"; //
        //when
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

    @DisplayName("like 연산자를 활용한 조회 테스트")
    @Test
    public void listoperatorTest(){

        //given
        String jpql = "SELECT m FROM menu_section01 m WHERE m.menuName LIKE '%마늘%'";
        //when
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }
}
