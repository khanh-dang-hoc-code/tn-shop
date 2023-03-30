package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.order.CreateNewOrderRequest;
import com.tech.tnshop.dto.request.order.UpdateOrderRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.Order;
import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IOrderRepository;
import com.tech.tnshop.service.IOrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final AuthenticateService authenticateService;

    @Override
    public ResponseEntity<Object> createNewOrder(CreateNewOrderRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> update(UpdateOrderRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getAllOrder(HttpServletRequest servletRequest, int index, int limit) {
        User user = authenticateService.getUserFromToken(servletRequest);
        List<Order> orderList = orderRepository.getAllByUserOrder(user.getId(), limit, index);
        return ResponseEntity.ok(new AbstractResponse(orderList));
    }

    @Override
    public ResponseEntity<Object> removeOrder(HttpServletRequest servletRequest, String orderId) {
        String userId = authenticateService.getUserIdFromToken(servletRequest);
        Order orderUpdate = getOrderById(orderId, userId);
        orderRepository.delete(orderUpdate);
        return ResponseEntity.ok(new MessageResponse("Delete success"));
    }

    @Override
    public ResponseEntity<Object> removeAllOrder(HttpServletRequest servletRequest, List<String> orderIds) {
        orderRepository.deleteAllById(orderIds);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public void updateOrderStatus(String orderId, String orderStatus, HttpServletRequest request) {
        String userId = authenticateService.getUserIdFromToken(request);
        Order orderUpdate = getOrderById(orderId, userId);
        orderUpdate.setOrderStatus(orderStatus);
        orderRepository.save(orderUpdate);
    }

    public Order getOrderById(String orderId, String userId) {
        return orderRepository.findById(userId, orderId)
                .orElseThrow(() -> new NotFoundException("Can not find order " + orderId));
    }
}
