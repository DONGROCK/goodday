package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /*
    * @Qualifier 어노테이션은 여러 개의 빈 객체 중에서 특정 빈 객체를 이름으로 지정하는 어노테이션이다.
    * @Primary 어노테이션과 @Qualifier어노테이션이 함께 쓰였을 때 @Qualifier가 우선 시 된다.
    * */
}
