package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {

    /*
    * @Resource 어노테이션은 자바에서 제공하는 기본 어노테이션이다.
    * @Autowired와 같은 스프링 어노테이션과 다르게 name 속성값으로 의존성 주입을 할 수 있다.
    * */

    /*
    * 'javax.annotation:javax.annotation-api:1.3.2 추가후에 @Resource import가능
    * */
//    @Resource(name="pikachu")
//    private Pokemon pokemon;
//
//    public void pokemonAttack() {
//        pokemon.attack();
//    }

    /*
    * List<Pokemon> 타입으로 변경한 뒤 name 속성을 기재하지 않고 동작하기 확인
    *
    * 기본적으로 name 속성을 통해 주입하지만 name 속성이 없을 경우 Type을 통해서 의존성 주입한다.
    * */
    @Resource
    private List<Pokemon> pokemonList;

    public void pokemonAttack() {
        pokemonList.forEach(Pokemon::attack);
    }
}
