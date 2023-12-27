package com.ohgiraffers.section02.initdestory.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.ohgiraffers.section02.initdestory.subsection01.java")
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {

        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {

        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {

        return new ShoppingCart();
    }

    /* init-method로 openShop 메소드 설정
    *  destory-method로 closeShop 메소드 설정
    * */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }
}
