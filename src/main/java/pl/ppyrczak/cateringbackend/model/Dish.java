package pl.ppyrczak.cateringbackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.ppyrczak.cateringbackend.util.Cuisine;
import pl.ppyrczak.cateringbackend.util.Meal;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document
public class Dish {
    @Id
    private String id;
    private String imageUrl;
    private String name;
    private Cuisine cuisine;
    private Meal meal;
    private String ingredients;
    private int limit;
    private BigDecimal price;
    private String description;

    @Transient
//  @JsonIgnore
    private int amount;

    public Dish(String imageUrl,
                String name,
                Cuisine cuisine,
                Meal meal,
                String ingredients,
                int limit,
                BigDecimal price,
                String description) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.cuisine = cuisine;
        this.meal = meal;
        this.ingredients = ingredients;
        this.limit = limit;
        this.price = price;
        this.description = description;
    }
}
