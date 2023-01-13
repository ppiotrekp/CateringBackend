package pl.ppyrczak.cateringbackend.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public UserRole addRole(UserRole role) {
        return roleRepository.insert(role);
    }
}
