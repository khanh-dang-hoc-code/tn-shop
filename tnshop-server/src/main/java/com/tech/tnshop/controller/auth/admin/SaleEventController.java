package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.service.serviceImpl.SaleEventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/force-auth/admin/sale-event")
@RequiredArgsConstructor
public class SaleEventController {
    private final SaleEventServiceImpl saleEventService;
}
