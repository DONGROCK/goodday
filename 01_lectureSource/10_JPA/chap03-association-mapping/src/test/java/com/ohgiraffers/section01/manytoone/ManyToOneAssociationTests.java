package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

public class ManyToOneAssociationTests {

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

        /*Association Mapping은 Entity클래스간의 관계를 매핑하는 것을 의미한다.
        * 이를 통해 객체를 이용해 데이터베이스의 테이블 간의 관계를 매핑할 수 있다.
        *
        * 다중성에 의한 분류
        * 연관관계가 있는 객체 관계에서 실제로 연관을 가지는 객체의 수에 따라 분류된다.
        * - N : 1 (ManyToOne) 연관관계 // 김밥 : 분식 // 짜장 : 중식 // 짬뽕 : 중식 카테고리가 one이다
        * - 1 : N (OneToMany) 연관관계
        * - 1 : 1 (OneToOne) 연관관계
        * - N : N (ManyToMany) 연관관계
        *
        * 방향에 따른 분류
        * 테이블의 연관 관계는 외래캐를 이용하여 양방향 연관관계의 특징을 가진다.
        * 참조에 의한 객체의 연관 관계는 단방향이다.
        * 객체간의 연관 관계를 양방향으로 만들고 싶은 경우 반대 쪽에서도 필드를 추가해서 참조를 보관하면된다.
        * 하지만 엄밀하게 이는 양방향 관계가 아니라 단방향 관계 2개로 볼 수 있다.
        * - 단방향 연관 관계
        * - 양방향 연관 관계
        * */
    @DisplayName("다대일 연관관계 객체 그래프 탐색을 이용한 조회 테스트")
    @Test
    public void manyToOneAssociationTest(){
        //given
        int menuCode = 15;
        //when
        MenuAndCategory foundMenu = entityManager.find(MenuAndCategory.class, menuCode);
        //then
        System.out.println("foundMenu" + foundMenu);
    }
}
