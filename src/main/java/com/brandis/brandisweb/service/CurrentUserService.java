package com.brandis.brandisweb.service;

import com.brandis.brandisweb.model.buser.BUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {
    public BUser getUser(){
        SecurityContext securityContext =SecurityContextHolder
                .getContext();
        Authentication authentication = securityContext.getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof BUser) {
            return (BUser) principal;
        }else {
            return null;
        }
    }
}
