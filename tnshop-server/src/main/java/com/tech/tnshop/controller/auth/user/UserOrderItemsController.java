package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.service.impl.OrderItemsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 01/04/2023 - 09:35
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/order-items")
@RequiredArgsConstructor
public class UserOrderItemsController {

    private final OrderItemsServiceImpl service;
}
