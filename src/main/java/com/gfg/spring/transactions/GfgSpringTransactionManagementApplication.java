package com.gfg.spring.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class GfgSpringTransactionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GfgSpringTransactionManagementApplication.class, args);
    }

}
