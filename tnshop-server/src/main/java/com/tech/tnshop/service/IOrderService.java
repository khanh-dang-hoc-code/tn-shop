package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.order.CreateNewOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    ResponseEntity<Object> createNewOrder(CreateNewOrderRequest request);
//    ResponseEntity<Object> createNewOrder(CreateNewOrderRequest request);
//    ResponseEntity<Object> createNewOrder(CreateNewOrderRequest request);
//    ResponseEntity<Object> createNewOrder(CreateNewOrderRequest request);
}
