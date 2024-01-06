package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* JpaRepository를 상속받아서 사용하는 메소드 외의 메소드는 직접 정의한다.
* JpaRepository<엔티티명, 엔티티의 Pk에 해당하는 타입>
*/
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
