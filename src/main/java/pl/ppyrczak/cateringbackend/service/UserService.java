package pl.ppyrczak.cateringbackend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ppyrczak.cateringbackend.exception.EmailExistsException;
import pl.ppyrczak.cateringbackend.model.User;
import pl.ppyrczak.cateringbackend.repository.UserRepository;
import pl.ppyrczak.cateringbackend.role.EUserRole;
import pl.ppyrczak.cateringbackend.role.RoleRepository;
import pl.ppyrczak.cateringbackend.role.UserRole;

import java.util.*;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    Set<UserRole> roles = new HashSet<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (user == null) {
            log.error("User not found");
        } else {
            log.info("User found");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles()
                .forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().toString())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                authorities);
    }

    public User signUpUser(User user) {
//        boolean userExists = userRepository.findByUsername(user.getUsername())
//                .isPresent();

//        if (userExists) {
//            throw new EmailTakenException();
//        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        return addUser(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        UserRole userRole = roleRepository.findByName(EUserRole.ROLE_CLIENT).get();
        roles.add(userRole);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRoles(roles);
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailExistsException();
        }
        return userRepository.insert(user);
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public void changeEnabledStatus(String id) {
        User user = userRepository.findById(id).get();
        user.setEnabled(!user.isEnabled());
        userRepository.save(user);
    }

    public Stream<String> getUserIdByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByEmail(email));
        System.out.println(user);
        Stream<String> id = user.stream().map(User::getId);
        System.out.println("id" + id);
        return id;
    }
}
