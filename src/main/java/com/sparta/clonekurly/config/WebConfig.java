package com.sparta.clonekurly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// CORS 설정을 GLOBAL하게(전체 PJT에 한 번에) 적용하는 클래스
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // CORS를 적용할 URL 패턴 정의?? 아래는 Default
                                            //Allow all origins.
                                            //Allow "simple" methods GET, HEAD and POST.
                                            //Allow all headers.
                                            //Set max age to 1800 seconds (30 minutes).
            .allowedOrigins("*") // 허락할 Origin을 지정 ex) "http://localhost:8080", "http://localhost:8081"
            .allowedMethods("*") // 허욜할 HTTP method를 지정 ex) "GET","POST"
            .maxAge(3600); //  pre-flight 리퀘스트를 캐싱 해두는 시간 지정. seconds 단위

    }
}

