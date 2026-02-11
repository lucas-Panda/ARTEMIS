package com.artemis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtemisApplication{
    public static void main(String[] args){
        SpringApplication.run(ArtemisApplication.class, args);

        System.out.println("API KEY: " + System.getenv("OPENAI_API_KEY"));
    }
}