package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.orderItems.AddNewOrderItemRequest;
import com.tech.tnshop.dto.request.orderItems.UpdateOrderItemRequest;
import com.tech.tnshop.entity.Order;
import com.tech.tnshop.entity.OrderItems;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IOrderItemsRepository;
import com.tech.tnshop.service.IOrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements IOrderItemsService {

    private final IOrderItemsRepository orderItemsRepository;

    @Override
    public ResponseEntity<Object> addNewOrderItem(AddNewOrderItemRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateOrderItem(UpdateOrderItemRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> removeOrderItem(String orderItem) {
        return null;
    }

    @Override
    public ResponseEntity<Object> removeAllOrderItemInOrder(List<String> orderIds) {
        return null;
    }

    @Override
    public List<OrderItems> getAllOrderItemsInOrder(Order order) {
        return order.getOrderItemsList();
    }

    public OrderItems getOrderItemById(String orderItemId) {
        return orderItemsRepository.findById(orderItemId)
                .orElseThrow(() -> new NotFoundException("Can not find order id " + orderItemId));
    }
}
