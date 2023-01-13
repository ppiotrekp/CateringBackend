package pl.ppyrczak.cateringbackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ppyrczak.cateringbackend.model.Dish;

import java.util.List;

@Repository
public interface DishRepository extends MongoRepository<Dish, String> {
    @Query("select d from Dish d")
    List<Dish> findAllDishes(Pageable pageable);
}
