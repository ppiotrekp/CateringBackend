package pl.ppyrczak.cateringbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.ppyrczak.cateringbackend.model.OrderHistory;
import pl.ppyrczak.cateringbackend.model.User;
import pl.ppyrczak.cateringbackend.repository.OrderHistoryRepository;
import pl.ppyrczak.cateringbackend.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;
    private final UserService userService;

    public OrderHistory fillAnOrder(OrderHistory order, Authentication authentication) {
        List<User> users = userService.getUsers();
        String userLoggedId = "";

        for (User user : users) {
            if (user.getUsername().equals(authentication.getName())) {
                userLoggedId = user.getId();
            }
        }



        System.out.println(userLoggedId);
        order.setUserId(userLoggedId);
        order.setTotalPrice();
        order.setDate();
        return orderHistoryRepository.insert(order);
    }

    public List<OrderHistory> getOrderHistory(String id) {
        return orderHistoryRepository.findByUserId(id);
    }
}
