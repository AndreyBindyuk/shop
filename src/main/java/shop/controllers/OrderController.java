package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.models.Order;
import shop.services.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/shop/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    private String createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @RequestMapping(value = "/findByOrderId", method = RequestMethod.GET)
    private Order findByOrderId(@RequestParam("orderId") String orderId) {
        return orderService.findByOrderId(orderId);
    }

    @RequestMapping(value = "/findActiveOrders", method = RequestMethod.GET)
    private List<Order> findActiveOrders() {
        return orderService.findActiveOrders();
    }

    @RequestMapping(value = "/findProcessedOrders", method = RequestMethod.GET)
    private List<Order> findProcessedOrders() {
        return orderService.findProcessedOrders();
    }

    @RequestMapping(value = "/updateOrderStatus", method = RequestMethod.POST)
    private Order updateOrderStatus(@RequestParam("orderId") String orderId, @RequestParam("orderStatus") String orderStatus) {
        return orderService.updateOrderStatus(orderId, orderStatus);
    }
}
