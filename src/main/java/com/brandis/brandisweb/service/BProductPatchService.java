package com.brandis.brandisweb.service;

import com.brandis.brandisweb.model.BProduct;
import com.brandis.brandisweb.model.BProductBatch;
import com.brandis.brandisweb.repository.BProductPatchRepository;
import com.brandis.brandisweb.util.DateUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BProductPatchService implements BaseService<BProductBatch>,
        IProductBaseService<BProductBatch> {

    private BProductPatchRepository repository;

    @Override
    public List<BProductBatch> findAll() {
        return repository.findAll();
    }

    @Override
    public BProductBatch save(BProductBatch entity) {
        return repository.save(entity);
    }

    @Override
    public BProductBatch findById(long id) {
        final Optional<BProductBatch> bProductPatchOpt = repository.findById(id);
        if(bProductPatchOpt.isPresent()){
            return bProductPatchOpt.get();
        }else {
            throw new IllegalArgumentException("No product batch found");
        }
    }

    @Override
    public void delete(BProductBatch entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    public BProductBatch create(Long amount, Date dateOfPurchase, BProduct product){
        BProductBatch bProductBatch = new BProductBatch();
        bProductBatch.setDateBought(dateOfPurchase);
        bProductBatch.setAmount(amount);
        bProductBatch.setBProduct(product);
        bProductBatch.setExpirationDate(DateUtil.addDate(dateOfPurchase,
                product.getDaysTillExpiration()));
        return repository.save(bProductBatch);
    }

}
