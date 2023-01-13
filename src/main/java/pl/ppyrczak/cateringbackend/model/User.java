package pl.ppyrczak.cateringbackend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.ppyrczak.cateringbackend.role.UserRole;

import javax.persistence.Id;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Document
public class User implements UserDetails {
    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @DBRef
    private Set<UserRole> roles = new HashSet<>();

    public User(String name,
                String surname,
                String email,
                String password,
                Set<UserRole> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    List<GrantedAuthority> authorities = getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName().name()))
            .collect(Collectors.toList());

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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
