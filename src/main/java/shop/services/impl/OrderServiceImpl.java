package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import shop.dao.OrderRepository;
import shop.models.Order;
import shop.services.OrderService;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public String createOrder(Order order) {
        return orderRepository.insert(order).getId();
    }

    public Order findByOrderId(String id) {
        return orderRepository.findOne(id);
    }

    public List<Order> findActiveOrders() {
        Criteria criteria = new Criteria();
        criteria.and("orderStatus").is("pending");
        return mongoTemplate.find(new Query(criteria), Order.class);
    }

    public List<Order> findProcessedOrders() {
        Criteria criteria = new Criteria();
        criteria.and("orderStatus").is("success").is("failed");
        return mongoTemplate.find(new Query(criteria), Order.class);
    }

    public Order updateOrderStatus(String orderId, String orderStatus) {
        Order order = mongoTemplate.findById(orderId, Order.class);
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }
}
