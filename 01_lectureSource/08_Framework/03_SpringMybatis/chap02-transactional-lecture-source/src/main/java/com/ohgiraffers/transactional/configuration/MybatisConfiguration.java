package com.ohgiraffers.transactional.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/*MapperScan : dao용으로 만든 인터페이스에 @Mapper라는 어노테이션이 붙어있는 클래스들만
*              탐색해서 빈으로 등록하도록 탐색하는 어노테이션
* */
@MapperScan(basePackages = "com.ohgiraffers.transactional", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
