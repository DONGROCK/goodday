package com.ohgiraffers.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import javax.crypto.interfaces.PBEKey;

public class A_EntityManagerLifeCycleTests {

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

    @Test
    public void 엔터티_매니저_팩토리와_엔터티_매니저_생명주기_확인1(){

        System.out.println("entityManagerFactory.hashCode : " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode : " + entityManager.hashCode());

    }

    @DisplayName("엔티티 매니저 팩토리와 엔터티 매니저 생명주기 확인2")
    @Test
    public void test2(){
        System.out.println("entityManagerFactory.hashCode : " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode : " + entityManager.hashCode());

    }

    @AfterAll
    public static void closeFactory(){
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager(){
        entityManager.close();
    }
}
