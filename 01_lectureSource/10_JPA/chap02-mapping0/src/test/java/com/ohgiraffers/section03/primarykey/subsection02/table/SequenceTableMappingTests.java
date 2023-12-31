package com.ohgiraffers.section03.primarykey.subsection02.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

public class SequenceTableMappingTests {

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

    @DisplayName("식별자 매핑 테스트")
    @Test
    public void identityMappingTest(){

        //given
        Member member = new Member();
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickname("홍길동");
        member.setPhone("010-1111-2222");
        member.setAddress("서울시 종로구");
        member.setEnrollDate(new Date());
        member.setMemberRole("ROLE_MEMBER");
        member.setStatus("Y");

        Member member2 = new Member();
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickname("이순신");
        member2.setPhone("010-3333-4444");
        member2.setAddress("서울시 성북구");
        member2.setEnrollDate(new Date());
        member2.setMemberRole("ROLE_MEMBER");
        member2.setStatus("Y");
        //when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin(); //db반영 시작

        entityManager.persist(member); //영속화
        entityManager.persist(member2); //영속화

        entityTransaction.commit(); //db에 전송~

        //then
        String jpql = "SELECT A.memberNo FROM member_section03_subsection02 A";
        //jpql의 결과타입을 Integer.class로 타입지정
        List<Integer> memberNoList = entityManager.createQuery(jpql, Integer.class).getResultList();

        memberNoList.forEach(System.out::println);

    }
}
