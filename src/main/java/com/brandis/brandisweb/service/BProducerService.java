package com.brandis.brandisweb.service;

import com.brandis.brandisweb.model.bproducer.BProducer;
import com.brandis.brandisweb.repository.BProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BProducerService implements BaseService<BProducer>{

    private BProducerRepository repository;
    @Override
    public List<BProducer> findAll() {
        return repository.findAll();
    }

    @Override
    public BProducer save(BProducer entity) {
        return repository.save(entity);
    }

    @Override
    public BProducer findById(long id) {
        final Optional<BProducer> bProducerOpt = repository.findById(id);
        if(bProducerOpt.isPresent()){
            return bProducerOpt.get();
        }else{
            throw new IllegalArgumentException("No producer found");
        }
    }

    @Override
    public void delete(BProducer entity) {
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
}
