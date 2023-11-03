package edu.miu.adsApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdsWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsWebapiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            System.out.println("Hello Lab7WebApi");
        };
    }
}
