package com.brandis.brandisweb.config;

import com.brandis.brandisweb.model.BUser;
import com.brandis.brandisweb.service.BUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@Configuration
public class DatabaseInitzr {

    @Autowired
    private BUserService bUserService;


    @Bean
    CommandLineRunner initDatabase1(){

        return args -> {
            BUser user0 = bUserService.register("test@test", "test");
            Assert.notNull(user0);
        };
    }
}
