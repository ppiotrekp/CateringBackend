package pl.ppyrczak.cateringbackend.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ppyrczak.cateringbackend.model.User;
import pl.ppyrczak.cateringbackend.role.EUserRole;
import pl.ppyrczak.cateringbackend.role.RoleRepository;
import pl.ppyrczak.cateringbackend.role.UserRole;
import pl.ppyrczak.cateringbackend.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final RoleRepository roleRepository;
    Set<UserRole> roles = new HashSet<>();



    public User register(RegistrationRequest request) {
        UserRole userRole = roleRepository.findByName(EUserRole.valueOf("ROLE_ADMIN"));
        roles.add(userRole);

        return userService.signUpUser(new User(
                request.getName(),
                request.getSurname(),
                request.getEmail(),
                request.getPassword(),
                roles
        ));
    }
}
