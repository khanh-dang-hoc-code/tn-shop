package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.cart.RemoveListProductCartRequest;
import com.tech.tnshop.dto.request.orderItems.AddNewOrderItemRequest;
import com.tech.tnshop.dto.request.orderItems.RemoveListOrderItemRequest;
import com.tech.tnshop.service.serviceImpl.CartServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${user-auth}/cart")
public class UserCartController {
    private final CartServiceImpl cartService;


    @PostMapping("/add")
    public ResponseEntity<Object> addProductToCart(HttpServletRequest request, @RequestBody AddNewOrderItemRequest orderItemRequest) {
        return cartService.addOrderItemToCart(request, orderItemRequest);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> removeProductFromCart(HttpServletRequest request, @RequestParam String orderItemId) {
        return cartService.removeOrderItemToCart(request, orderItemId);
    }

    @DeleteMapping("/deleteAllProduct")
    public ResponseEntity<Object> removeListProductFromCart(HttpServletRequest servletRequest, RemoveListOrderItemRequest request) {
        return cartService.removeListOrderItemCart(servletRequest, request.getIds());
    }
}
