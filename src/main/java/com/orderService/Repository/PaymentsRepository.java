package com.orderService.Repository;

import com.orderService.models.Payments;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentsRepository extends MongoRepository<Payments, ObjectId> {
}
