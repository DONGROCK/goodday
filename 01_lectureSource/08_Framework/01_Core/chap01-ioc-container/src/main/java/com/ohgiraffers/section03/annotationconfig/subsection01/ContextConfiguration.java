package com.ohgiraffers.section03.annotationconfig.subsection01;

//import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Configuration("ConfigurationSection03")
//@ComponentScan(basePackages = "com.ohgiraffers")
//@ComponentScan(basePackages =  "com.ohgiraffers",
//                excludeFilters = {
//                  @ComponentScan.Filter(
                          /*1. 타입으로 설정*/
//                          type = FilterType.ASSIGNABLE_TYPE,
//                          classes = {MemberDAO.class}
                          /*2. 어노테이션 종류로 설정*/
//                          type = FilterType.ANNOTATION,
//                          classes = {org.springframework.stereotype.Component.class}
                          /*3. 표현식으로 설정*/
//                          type=FilterType.REGEX,
//                          pattern = {"com.ohgiraffers.section03.annotationconfig.java.*"}
//                        )
//                }
//)

//범위안에 있는 것을 가져다가 쓰는 것 id, type, id와type같이 있는것
@ComponentScan(basePackages = "com.ohgiraffers",
useDefaultFilters = false,
includeFilters = {
        @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {MemberDAO.class}
        )
    }
)

public class ContextConfiguration {

}
