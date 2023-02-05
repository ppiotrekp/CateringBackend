package pl.ppyrczak.cateringbackend.role;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<UserRole, String > {
    UserRole findByName(EUserRole name);

}
