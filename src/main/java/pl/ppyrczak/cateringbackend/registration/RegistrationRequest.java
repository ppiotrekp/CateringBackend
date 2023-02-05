package pl.ppyrczak.cateringbackend.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Set<? extends GrantedAuthority> authorities;
}
