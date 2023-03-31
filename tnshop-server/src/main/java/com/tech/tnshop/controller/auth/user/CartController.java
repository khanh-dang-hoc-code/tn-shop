package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.cart.RemoveListProductCartRequest;
import com.tech.tnshop.service.serviceImpl.CartServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${user-auth}/cart")
public class CartController {
    private final CartServiceImpl cartService;


    @PostMapping("/add")
    public ResponseEntity<Object> addProductToCart(HttpServletRequest request, String productId) {
        return cartService.addProductToCart(request, productId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> removeProductFromCart(HttpServletRequest request, @RequestParam String productId) {
        return cartService.removeProductToCart(request, productId);
    }

    @DeleteMapping("/deleteAllProduct")
    public ResponseEntity<Object> removeListProductFromCart(HttpServletRequest servletRequest, RemoveListProductCartRequest request) {
        return cartService.removeListProductCart(servletRequest, request.getIdsDelete());
    }
}
