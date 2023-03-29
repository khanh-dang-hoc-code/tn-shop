package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.order.CreateNewOrderRequest;
import com.tech.tnshop.entity.Order;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IOrderRepository;
import com.tech.tnshop.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;

    @Override
    public ResponseEntity<Object> createNewOrder(CreateNewOrderRequest request) {
        return null;
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Can not find order " + orderId));
    }
}
