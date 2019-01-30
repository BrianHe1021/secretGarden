package edu.oregonstate.secretgarden;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.oregonstate.secretgarden.mapper")
public class SecretGardenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretGardenApplication.class, args);
    }

}

