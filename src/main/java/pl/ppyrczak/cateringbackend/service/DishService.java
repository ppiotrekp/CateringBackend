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
}