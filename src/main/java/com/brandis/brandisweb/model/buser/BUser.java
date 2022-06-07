package com.brandis.brandisweb.model.buser;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BUser")
public class BUser implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true, length = 100)
    private String email;

    @NotNull
    private String password;

    private Date dateCreated;

    @PrePersist
    private void prePersist(){
        dateCreated = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("USER");
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
