package com.orderService.orderService;

import com.orderService.Repository.OrderRepository;
import com.orderService.Repository.PaymentsRepository;
import com.orderService.models.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    private PaymentsRepository paymentsRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PaymentsRepository paymentsRepository) {
        this.orderRepository = orderRepository;
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public Orders saveOrder(List<CartDTO> cartItems, Float amount,Long userId) {
        Orders order=new Orders();
        order.setCreateAt(LocalTime.now());
        order.setProducts(cartItems);
        order.setUserId(userId);
        Payments payment =new Payments();
        payment.setModeOfPayment("Card");
        payment.setAmount(amount);
        payment.setStatus("Success");
        Payments finPayment=paymentsRepository.save(payment);
        order.setPayments(finPayment);
        Orders finOrder=orderRepository.save(order);
        return finOrder;


    }

    @Override
    public Optional<Orders> getOrderById(ObjectId objectId) {

        Optional<Orders> order=orderRepository.findById(objectId);
        return order;
    }

    @Override
    public List<Orders> getOrdersForUser(Long userId) {
        List<Orders> orders=orderRepository.findByUserId(userId);
        return orders;
    }
}
