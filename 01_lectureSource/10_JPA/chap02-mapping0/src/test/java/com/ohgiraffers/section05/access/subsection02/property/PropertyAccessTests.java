package com.ohgiraffers.section05.access.subsection02.property;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

public class PropertyAccessTests {
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

        @DisplayName("프로퍼티 접근 테스트")
    @Test
    public void propertyAccessTest(){
            //given
            Member member = new Member();
            member.setMemberNo(1);
            member.setMemberId("user01");
            member.setMemberPwd("pass01");
            member.setNickname("홍길동");
            //when
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(member);
            entityTransaction.commit();

            //then
            String jpql = "SELECT a.nickname FROM member_section05_subsection02 a WHERE a.memberNo = 1";
            //쿼리의 결과값을 가져옴 결과값을 registedNickname 변수에 저장
            String registedNickname = entityManager.createQuery(jpql, String.class).getSingleResult();
            //닉네임get에 + 님을 붙여서 홍길동님과 값이 같아짐
            Assertions.assertEquals("홍길동님", registedNickname);

        }
}
