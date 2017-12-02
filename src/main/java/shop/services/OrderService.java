package shop.services;

import shop.models.Order;

import java.util.List;

public interface OrderService {

    String createOrder(Order order);

    Order findByOrderId(String id);

    List<Order> findActiveOrders();

    List<Order> findProcessedOrders();

    Order updateOrderStatus(String orderId, String orderStatus);
}
