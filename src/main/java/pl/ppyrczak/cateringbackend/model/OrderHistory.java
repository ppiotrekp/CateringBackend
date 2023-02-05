package pl.ppyrczak.cateringbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
@Setter
public class OrderHistory {
    @Id
    private String id;
    private String userId;
    private List<Dish> dishes;
    private int totalPrice;
    private LocalDateTime date;

    public void setTotalPrice() {
        dishes.forEach(dish -> this.totalPrice += dish.getPrice().intValue() * dish.getAmount());
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }
    
}
