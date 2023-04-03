package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.request.order_items.AddNewOrderItemRequest;
import com.tech.tnshop.entity.Cart;
import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.ICartRepository;
import com.tech.tnshop.service.ICartService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final ICartRepository cartRepository;
    private final AuthenticateService authenticateService;
    private final OrderItemsServiceImpl orderItemsService;
    @Override
    public void createNewCart(User user) {
        Cart cart = new Cart();
        cart.setCartUser(user);
        cartRepository.save(cart);
    }

    @Override
    public ResponseEntity<Object> addOrderItemToCart(HttpServletRequest servletRequest, AddNewOrderItemRequest request) {
        Cart cart = getCartByServletRequest(servletRequest);
        request.setCartId(cart.getId());
        return orderItemsService.addNewOrderItem(request);
    }

    @Override
    public ResponseEntity<Object> removeOrderItemToCart(HttpServletRequest request, String orderItemId) {
        return orderItemsService.removeOrderItem(orderItemId);
    }

    @Override
    public ResponseEntity<Object> removeListOrderItemCart(HttpServletRequest request, List<String> orderItemsId) {
        return orderItemsService.removeAllOrderItemInOrder(orderItemsId);
    }

    public Cart findCartById(String cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new NotFoundException("Can not find cart " + cartId));
    }

    private Cart getCartByServletRequest(HttpServletRequest request) {
        User user = authenticateService.getUserFromToken(request);
        return user.getCartUser();
    }
}
