package com.brandis.brandisweb.service;

import com.brandis.brandisweb.model.BProduct;
import com.brandis.brandisweb.model.BSavedProductBatch;
import com.brandis.brandisweb.repository.BSavedProductBatchRepository;
import com.brandis.brandisweb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BSavedProductBatchService implements BaseService<BSavedProductBatch>, IProductBaseService<BSavedProductBatch> {

    @Autowired
    private BSavedProductBatchRepository repository;

    @Override
    public List<BSavedProductBatch> findAll() {
        return repository.findAll();
    }

    @Override
    public BSavedProductBatch save(BSavedProductBatch entity) {
        return repository.save(entity);
    }

    @Override
    public BSavedProductBatch findById(long id) {
        final Optional<BSavedProductBatch> bProductPatchOpt = repository.findById(id);
        if(bProductPatchOpt.isPresent()){
            return bProductPatchOpt.get();
        }else {
            throw new IllegalArgumentException("No product saved batch found");
        }
    }

    @Override
    public void delete(BSavedProductBatch entity) {
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

    @Override
    public BSavedProductBatch create(Long amount, Date dateOfPurchase, BProduct product) {
        BSavedProductBatch savedProductBatch = new BSavedProductBatch();
        savedProductBatch.setDateBought(dateOfPurchase);
        savedProductBatch.setAmount(amount);
        savedProductBatch.setBProduct(product);
        savedProductBatch.setExpirationDate(DateUtil.addDate(dateOfPurchase,
                product.getDaysTillExpiration()));
        return repository.save(savedProductBatch);
    }
}
