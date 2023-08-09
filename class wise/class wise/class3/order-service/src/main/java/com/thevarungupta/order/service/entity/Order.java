package com.thevarungupta.order.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "orders"
)
public class Order {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long orderId;

    @Column(name =  "product_id")
    private Long productId;

    private Long quantity;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "order_status")
    private String orderStatus;

    private Long amount;
}
