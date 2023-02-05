package pl.ppyrczak.cateringbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.ppyrczak.cateringbackend.model.OrderHistory;
import pl.ppyrczak.cateringbackend.service.OrderHistoryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class OrderHistoryController {
    private final OrderHistoryService orderHistoryService;

    @PostMapping("/checkout")
    public OrderHistory fillAnOrder(@RequestBody OrderHistory order, Authentication authentication) {
        return orderHistoryService.fillAnOrder(order, authentication);
    }

    @GetMapping("/history/{id}")
    public List<OrderHistory> getOrderHistory(@PathVariable String id) {
        return orderHistoryService.getOrderHistory(id);
    }


}
