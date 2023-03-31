package com.tech.tnshop.service;


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

    ResponseEntity<Object> addProductToCart(HttpServletRequest request, String productId);
    ResponseEntity<Object> removeProductToCart(HttpServletRequest request, String productId);
    ResponseEntity<Object> removeListProductCart(HttpServletRequest request, List<String> productId);

}
