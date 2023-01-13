package pl.ppyrczak.cateringbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.ppyrczak.cateringbackend.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String e);
}
