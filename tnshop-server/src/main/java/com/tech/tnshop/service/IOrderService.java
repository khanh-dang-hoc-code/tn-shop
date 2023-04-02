package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.order.AddNewOrderRequest;
import com.tech.tnshop.dto.request.order.UpdateOrderRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IOrderService {
    ResponseEntity<Object> createNewOrder(AddNewOrderRequest request);
    ResponseEntity<Object> update(UpdateOrderRequest request);
    ResponseEntity<Object> getAllOrder(HttpServletRequest servletRequest, int index, int limit);
    ResponseEntity<Object> removeOrder(HttpServletRequest servletRequest, String orderId);
    ResponseEntity<Object> removeAllOrder(HttpServletRequest servletRequest, List<String> orderId);

    void updateOrderStatus(String orderId, String orderStatus, HttpServletRequest request);
}
