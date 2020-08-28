package com.example.oauth2ssoauthserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.example.oauth2ssoauthserver.mapper")
@RestController
public class Oauth2SsoAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2SsoAuthServerApplication.class, args);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
