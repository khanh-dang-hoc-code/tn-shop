package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.mapper.OrderMapper;
import com.tech.tnshop.dto.request.order.AddNewOrderRequest;
import com.tech.tnshop.dto.request.order.UpdateOrderRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.Order;
import com.tech.tnshop.entity.OrderItems;
import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IOrderRepository;
import com.tech.tnshop.service.IOrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final AuthenticateService authenticateService;
    private final OrderItemsServiceImpl orderItemsService;


    @Override
    public ResponseEntity<Object> createNewOrder(AddNewOrderRequest request) {
        Order order = OrderMapper.mapToOrderEntity(request);
        List<OrderItems> orderItems = request.getOrderItemsIds().stream()
                .map(orderItemsService::getOrderItemById)
                .toList();
        order.setOrderItemsList(orderItems);
        orderRepository.save(order);
        return ResponseEntity.ok(new AbstractResponse(order));
    }

    @Override
    public ResponseEntity<Object> update(UpdateOrderRequest request) {
        Order orderUpdate = getOrderById(request.getId());
        List<OrderItems> listOrderItems = request.getOrderItemsIds().stream()
                                                 .map(orderItemsService::getOrderItemById)
                                                 .toList();
        orderUpdate.setOrderItemsList(listOrderItems);
        orderRepository.save(orderUpdate);
        return ResponseEntity.ok(new MessageResponse("Update order " + request.getId() + " successfully"));
    }

    @Override
    public ResponseEntity<Object> getAllOrder(HttpServletRequest servletRequest, int index, int limit) {
        User user = authenticateService.getUserFromToken(servletRequest);
        List<Order> orderList = orderRepository.getAllByUserOrder(user.getId(), limit, index);
        return ResponseEntity.ok(new AbstractResponse(orderList));
    }

    @Override
    public ResponseEntity<Object> removeOrder(HttpServletRequest servletRequest, String orderId) {
        orderRepository.deleteById(orderId);
        return ResponseEntity.ok(new MessageResponse("Delete order " + orderId + " successfully"));
    }

    @Override
    public ResponseEntity<Object> removeAllOrder(HttpServletRequest servletRequest, List<String> orderIds) {
        orderRepository.deleteAllById(orderIds);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public ResponseEntity<Object> getAllOrderItemsInOrder(String orderId) {
        return ResponseEntity.ok(new AbstractResponse(orderItemsService.getAllOrderItemsInOrder(orderId)));
    }

    @Override
    public void updateOrderStatus(String orderId, String orderStatus, HttpServletRequest request) {
        Order orderUpdate = getOrderById(orderId);
        orderUpdate.setOrderStatus(orderStatus);
        orderRepository.save(orderUpdate);
    }

    public ResponseEntity<Object> findOrderById(String orderId) {
        return ResponseEntity.ok(new AbstractResponse(getOrderById(orderId)));
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Can not find order " + orderId));
    }
}
