package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.service.serviceImpl.SaleEventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${admin-auth}/sale-event")
@RequiredArgsConstructor
public class SaleEventController {
    private final SaleEventServiceImpl saleEventService;
}
