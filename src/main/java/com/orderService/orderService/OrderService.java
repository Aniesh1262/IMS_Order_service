package com.orderService.orderService;

import com.orderService.models.CartDTO;
import com.orderService.models.Orders;
import com.orderService.models.ProductDetailDTO;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Orders saveOrder(List<CartDTO> cartItems, Float amount,Long userId) ;

    Optional<Orders> getOrderById(ObjectId objectId);

    List<Orders> getOrdersForUser(Long userId);
}
