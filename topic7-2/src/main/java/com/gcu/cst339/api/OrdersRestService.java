package com.gcu.cst339.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.cst339.data.model.OrderModel;
import com.gcu.cst339.service.OrdersBusinessService;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
    @Autowired
    OrdersBusinessService service;

    @GetMapping(path = "/orders")
    public ResponseEntity<?> getOrders() {
        try {
            List<OrderModel> orders = service.getAllOrders();
            if (orders.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
