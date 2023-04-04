package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.mapper.OrderItemMapper;
import com.tech.tnshop.dto.request.order_items.AddNewOrderItemRequest;
import com.tech.tnshop.dto.request.order_items.UpdateOrderItemRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.Order;
import com.tech.tnshop.entity.OrderItems;
import com.tech.tnshop.entity.Product;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IOrderItemsRepository;
import com.tech.tnshop.service.IOrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements IOrderItemsService {

    private final IOrderItemsRepository orderItemsRepository;
    private final ProductServiceImpl productService;

    @Override
    public ResponseEntity<Object> addNewOrderItem(AddNewOrderItemRequest request) {
        OrderItems orderItems = OrderItemMapper.mapToOrderItemsEntity(request);
        Product product = productService.findProductById(request.getProductId());
        orderItems.setProductOrderItem(product);
        orderItems.setAmount(product.getPriceSold().multiply(new BigDecimal(request.getQuantity())));
        orderItemsRepository.save(orderItems);
        return ResponseEntity.ok(new AbstractResponse(orderItems));
    }

    @Override
    public ResponseEntity<Object> updateOrderItem(UpdateOrderItemRequest request) {
        OrderItems orderItemsUpdate = orderItemsRepository.getReferenceById(request.getOrderItemId());
        orderItemsUpdate.setQuantity(request.getQuantity());
        orderItemsRepository.save(orderItemsUpdate);
        return ResponseEntity.ok(new MessageResponse("Update orderItems " + request.getOrderItemId() + " successfully"));
    }

    @Override
    public ResponseEntity<Object> removeOrderItem(String orderItem) {
        orderItemsRepository.deleteById(orderItem);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public ResponseEntity<Object> removeAllOrderItemInOrder(List<String> orderIds) {
        orderItemsRepository.deleteAllById(orderIds);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public List<OrderItems> getAllOrderItemsInOrder(String orderId) {
        return orderItemsRepository.getALlOrderItemsInOrder(orderId);
    }

    @Override
    public List<OrderItems> getAllOrderItemsInCart(String cartId) {
        return orderItemsRepository.getALlOrderItemsInCart(cartId);
    }

    public OrderItems getOrderItemById(String orderItemId) {
        return orderItemsRepository.findById(orderItemId)
                .orElseThrow(() -> new NotFoundException("Can not find order id " + orderItemId));
    }
}
