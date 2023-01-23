package pl.ppyrczak.cateringbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.ppyrczak.cateringbackend.model.OrderHistory;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends MongoRepository<OrderHistory, String> {
    List<OrderHistory> findByUserId(String id);
}
