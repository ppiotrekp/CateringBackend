package pl.ppyrczak.cateringbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.ppyrczak.cateringbackend.model.Dish;
import pl.ppyrczak.cateringbackend.repository.DishRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class DishService {
    private static final int PAGE_SIZE = 9;
    private final DishRepository dishRepository;
    public Dish addDish(Dish dish) {
        return dishRepository.insert(dish);
    }
    public List<Dish> getDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> getAllDishes(int page) {
        return dishRepository.findAllDishes(
                PageRequest.of(page, PAGE_SIZE)
        );
    }
    public Dish getDish(String id) {
        return dishRepository.findById(id).get();
    }

    public void removeDish(String id) {
        dishRepository.deleteById(id);
    }

    public Dish updateDish(Dish dishToUpdate, String id) {
        return dishRepository.findById(id)
                .map(dish -> {
                    dish.setCuisine(dishToUpdate.getCuisine());
                    dish.setMeal(dishToUpdate.getMeal());
                    dish.setName(dishToUpdate.getName());
                    dish.setPrice(dishToUpdate.getPrice());
                    dish.setLimit(dishToUpdate.getLimit());
                    dish.setIngredients(dishToUpdate.getIngredients());
                    dish.setImageUrl(dishToUpdate.getImageUrl());
                    dish.setDescription(dishToUpdate.getDescription());
                    return dishRepository.save(dish);
                })
                .orElseGet(() -> {
                    return addDish(dishToUpdate);
                });
    }
}
