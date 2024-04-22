package com.orderService.Controllers;

import com.orderService.models.CartDTO;
import com.orderService.models.Orders;
import com.orderService.models.OrdersDTO;
import com.orderService.models.ProductDetailDTO;
import com.orderService.orderService.OrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Orders> placeOrder(@RequestBody OrdersDTO ordersDTO){
        Orders order=orderService.saveOrder(ordersDTO.getCartItems(),ordersDTO.getAmount(),ordersDTO.getUserId());
        return new ResponseEntity<>(order, HttpStatus.OK);

    }
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Optional<Orders>> getOrderById(@PathVariable ObjectId objectId){
        Optional<Orders> order=orderService.getOrderById(objectId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @GetMapping("/getOrders/{userId}")
    public ResponseEntity<List<Orders>> getOrdersForUser(@PathVariable Long userId){
        List<Orders> orders=orderService.getOrdersForUser(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
