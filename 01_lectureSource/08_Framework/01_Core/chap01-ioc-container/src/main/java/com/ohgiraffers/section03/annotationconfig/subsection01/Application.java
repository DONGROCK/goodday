package com.ohgiraffers.section03.annotationconfig.subsection01;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.section03.annotationconfig.subsection01.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /*
        * ComponentScan?  어느부분을 스캔해서 쓸꺼냐 하위에 컴포넌트스캔 -> 등록된것 가져오기
        * base package로 설정된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean으로 등록하는 기능이다.
        * @Component 어노테이션이 작성된 클래스를 인식하여 bean으로 등록한다.
        * 특수 목적에 따라 세부 긴으을 제공하는 @Conteroller,@Service,@Repository,@Configuration 등을 사용한다.
        * */

        ApplicationContext context
            = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames){
            System.out.println("beanName = " + beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);

        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "신삼다")));
        System.out.println(memberDAO.selectMember(3));
    }
}
