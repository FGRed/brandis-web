package com.brandis.brandisweb.config;

import com.brandis.brandisweb.model.bgame.BGame;
import com.brandis.brandisweb.model.bproduct.BProduct;
import com.brandis.brandisweb.model.bproductbatch.BProductBatch;
import com.brandis.brandisweb.model.bproductbatch.BSavedProductBatch;
import com.brandis.brandisweb.model.buser.BUser;
import com.brandis.brandisweb.repository.BGameRepository;
import com.brandis.brandisweb.repository.BProductRepository;
import com.brandis.brandisweb.service.BProductPatchService;
import com.brandis.brandisweb.service.BSavedProductBatchService;
import com.brandis.brandisweb.service.BUserService;
import com.brandis.brandisweb.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Configuration
public class DatabaseInitzr {

    @Autowired
    private BUserService bUserService;

    @Autowired
    private BProductPatchService bProductPatchService;

    @Autowired
    private BProductRepository bProductRepository;

    @Autowired
    private BSavedProductBatchService bSavedProductBatchService;

    @Autowired
    private BGameRepository bGameRepository;


    @Bean
    CommandLineRunner initDatabase1(){

        return args -> {
            BUser user0 = bUserService.register("test@test", "test");
            Assert.notNull(user0);

            BProduct bProduct = new BProduct();
            bProduct.setExpirationTime(30);
            bProduct.setName("Puikula");
            bProduct.setPrice(1.27);

            BProduct bProduct0 = bProductRepository.save(bProduct);
            Assert.notNull(bProduct0.getId());

            BProductBatch bProductBatch = bProductPatchService.create(100L, new Date(), bProduct0);
            Assert.notNull(bProductBatch.getId());

            BSavedProductBatch bSavedProductBatch = bSavedProductBatchService.createFromBatch(bProductBatch);
            Assert.notNull(bSavedProductBatch.getId());

            BGame bGame = new BGame();
            bGame.setCompanyName("Brandis");

            bGame = bGameRepository.save(bGame);

            bProductBatch.setBGame(bGame);

            bProductPatchService.save(bProductBatch);

            bGame.setProductBatches(Collections.singletonList(bProductBatch));

            bGameRepository.save(bGame);
            bSavedProductBatchService.save(bSavedProductBatch);
        };
    }
}
