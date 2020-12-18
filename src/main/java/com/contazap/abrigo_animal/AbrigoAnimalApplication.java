package com.contazap.abrigo_animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AbrigoAnimalApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AbrigoAnimalApplication.class, args);
    }

}
