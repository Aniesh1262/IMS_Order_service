package com.orderService.Repository;

import com.orderService.models.Orders;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Orders, ObjectId> {
    List<Orders> findByUserId(Long userId);
}
