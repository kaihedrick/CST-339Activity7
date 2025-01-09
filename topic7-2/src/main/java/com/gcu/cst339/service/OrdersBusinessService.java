package com.gcu.cst339.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.cst339.data.entity.OrderEntity;
import com.gcu.cst339.data.model.OrderModel;
import com.gcu.cst339.data.repository.OrdersRepository;

@Service
public class OrdersBusinessService {
    @Autowired
    private OrdersRepository ordersRepository;
    /**
     * Non-Default constructor for constructor injection
     */
    public OrdersBusinessService(OrdersRepository ordersRepository)
    {
        this.ordersRepository = ordersRepository;
    }
    /**
     * Get all the orders from the database
     */
    public List<OrderModel> getAllOrders()
    {
        //get all the entity orders
        List<OrderEntity> ordersEntity = ordersRepository.findAll();
        //option 2: Iterate over the entity orders and create a list of domain orders
        List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
        for(OrderEntity entity : ordersEntity)
        {
            ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
        }
        //return list of domain orders
        return ordersDomain;
    }
}
