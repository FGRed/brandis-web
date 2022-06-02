package com.brandis.brandisweb.config;

import com.brandis.brandisweb.model.BProduct;
import com.brandis.brandisweb.model.BProductBatch;
import com.brandis.brandisweb.model.BUser;
import com.brandis.brandisweb.repository.BProductPatchRepository;
import com.brandis.brandisweb.repository.BProductRepository;
import com.brandis.brandisweb.service.BProductPatchService;
import com.brandis.brandisweb.service.BUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.util.Date;

@Configuration
public class DatabaseInitzr {

    @Autowired
    private BUserService bUserService;

    @Autowired
    private BProductPatchService bProductPatchService;

    @Autowired
    private BProductRepository bProductRepository;


    @Bean
    CommandLineRunner initDatabase1(){

        return args -> {
            BUser user0 = bUserService.register("test@test", "test");
            Assert.notNull(user0);

            BProduct bProduct = new BProduct();
            bProduct.setDaysTillExpiration(30);
            bProduct.setName("Puikula");
            bProduct.setPrice(1.27);

            BProduct bProduct0 = bProductRepository.save(bProduct);
            Assert.notNull(bProduct.getId());

            BProductBatch bProductBatch = bProductPatchService.create(100L, new Date(), bProduct);
            Assert.notNull(bProductBatch.getId());



        };
    }
}
