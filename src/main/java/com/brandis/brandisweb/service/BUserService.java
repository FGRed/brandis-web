package com.brandis.brandisweb.service;

import com.brandis.brandisweb.exception.UserException;
import com.brandis.brandisweb.model.BUser;
import com.brandis.brandisweb.repository.BUserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BUserService implements BaseService<BUser>, UserDetailsService {

    private BUserRepository repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<BUser> findAll() {
        return repository.findAll();
    }

    @Override
    public BUser save(BUser entity) {
        return repository.save(entity);
    }

    @SneakyThrows
    @Override
    public BUser findById(long id) {
        Optional<BUser> bUserOptional = repository.findById(id);
        if(bUserOptional.isPresent()){
            return bUserOptional.get();
        }else {
            throw new UserException("User not found with id" + id);
        }
    }

    @Override
    public void delete(BUser entity) {
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

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<BUser> userOptional = repository.findBUserByEmail(email);
        if(userOptional.isPresent()){
            return userOptional.get();
        }else {
            throw new UserException("User not found with email" + email);
        }
    }

    public BUser register(final String email, final String password){
        BUser bUser = new BUser();
        bUser.setEmail(email);
        bUser.setPassword(bCryptPasswordEncoder.encode(password));
        return repository.save(bUser);
    }
}
