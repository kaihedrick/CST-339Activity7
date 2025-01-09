package com.gcu.cst339.data.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.gcu.cst339.data.entity.OrderEntity;

@Repository
public interface OrdersRepository extends MongoRepository<OrderEntity, String> {

    OrderEntity getOrderById(String id);
}
