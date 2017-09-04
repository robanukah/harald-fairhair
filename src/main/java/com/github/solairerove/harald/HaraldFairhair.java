package com.github.solairerove.harald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.github.solairerove.harald.domain.repository")
@SpringBootApplication
public class HaraldFairhair {
    public static void main(String... args) {
        SpringApplication.run(HaraldFairhair.class, args);
    }
}
