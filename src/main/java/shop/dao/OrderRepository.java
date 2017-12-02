package shop.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.models.Order;

@Transactional
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
