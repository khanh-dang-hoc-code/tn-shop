package com.tech.tnshop.service;


import com.tech.tnshop.dto.request.orderItems.AddNewOrderItemRequest;
import com.tech.tnshop.entity.User;
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
public interface ICartService {
    void createNewCart(User user);

    ResponseEntity<Object> addOrderItemToCart(HttpServletRequest servletRequest, AddNewOrderItemRequest request);
    ResponseEntity<Object> removeOrderItemToCart(HttpServletRequest request, String orderItemId);
    ResponseEntity<Object> removeListOrderItemCart(HttpServletRequest request, List<String> orderItemsId);

}
