package com.open.lms.repository;

import com.open.lms.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
    Optional<Order> findByPaymentId(String paymentId);
}
