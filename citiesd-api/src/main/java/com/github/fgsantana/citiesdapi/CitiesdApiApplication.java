package com.github.fgsantana.citiesdapi;

import com.github.fgsantana.citiesdapi.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class CitiesdApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(CitiesdApiApplication.class, args);
    }

    @GetMapping
    public Message start() {
        return new Message();
    }

}
