package com.ohgiraffers.thymeleafspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //사용자가 주소를 요청할 때
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");

        // 이미지 불러올 수 있도록 세팅
    //사용자가 주소를 요청할 때
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///c:/thymeleaf-springboot/upload/");

    //사용자가 주소를 요청할 때
        registry.addResourceHandler("/thumbPath/**")
                //경로 여기에 있는걸 불러온다.
                .addResourceLocations("file:///c:/thymeleaf-springboot/img/upload/thumbnail/");
    //사용자가 주소를 요청할 때
        registry.addResourceHandler("/imagePath/**")
                .addResourceLocations("file:///c:/thymeleaf-springboot/img/upload/original/");

    }
}
