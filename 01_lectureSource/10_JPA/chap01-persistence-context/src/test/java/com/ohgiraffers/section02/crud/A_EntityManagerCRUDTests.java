package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class A_EntityManagerCRUDTests {
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

    @DisplayName("메뉴코드로 메뉴 조회 테스트")
    @Test
    public void selectMenuByCode(){

        //given
        int menuCode = 2;
        //when
        //find 조회한다.
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        //then
        Assertions.assertNotNull(foundMenu); //foundMenu가 널이아닌지
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode()); //메뉴코드랑 파운드메뉴의 메뉴코드랑 같니?
        System.out.println("foundMenu = " + foundMenu);
    }

    @DisplayName("새로운 메뉴 추가")
    @Test
    public void insertNewMenu(){

        //given
        Menu menu = new Menu();
        menu.setMenuName("JPA테스트용 신규메뉴");
        menu.setMenuPrice(3000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("Y");
        //when

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin(); // 트랜잭션 시작. //인서트를 하기 위해

        try {
        // 영속성컨텍스트에 해당 내용을 담겟다. 메뉴를 담는다.
            //persist 인서트
            entityManager.persist(menu);
            entityTransaction.commit();
        } catch (Exception e) {
        entityTransaction.rollback();
        e.printStackTrace();
        }
        //then          //영속성컨텍스트에 menu 있냐
        Assertions.assertTrue(entityManager.contains(menu));
    }

    @DisplayName("메뉴 이름 수정 테스트")
    @Test
    public void modifyMenuName(){
        //given
        //ID가 32인 Menu엔티티를 DB에서 조회
        Menu menu = entityManager.find(Menu.class, 32);
        System.out.println("menu = " + menu);

        String menuNameToChange = "빼빼로튀김"; //변경할 이름
        //when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin(); //트랜잭션 시작 // 새로 값을 넣기 위해(수정)

        try {
            //ID32 메뉴네임에 빼빼로튀김 넣는다. (수정)
            menu.setMenuName(menuNameToChange);
            entityTransaction.commit();
        } catch (Exception e) {
        entityTransaction.rollback();
        e.printStackTrace();
        }

        //then
        Assertions.assertEquals(menuNameToChange, entityManager.find(Menu.class, 32).getMenuName());

    }

    @DisplayName("메뉴 삭제하기 테스트")
    @Test
    public void deleteMenuTest(){

        //given
        Menu menuToRemove = entityManager.find(Menu.class, 31);

        //when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(menuToRemove); // menuToRemove 삭제요청
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }

        //then
        Menu removedMenu = entityManager.find(Menu.class, 31); //null
        Assertions.assertEquals(null, removedMenu);
    }
}
