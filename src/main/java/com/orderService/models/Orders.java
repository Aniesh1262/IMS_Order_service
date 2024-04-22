package com.orderService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.List;

@Document(collation = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    private ObjectId orderId;
    private List<CartDTO> products;
    private Payments payments;
    private LocalTime createAt;
    private Long userId;

}
