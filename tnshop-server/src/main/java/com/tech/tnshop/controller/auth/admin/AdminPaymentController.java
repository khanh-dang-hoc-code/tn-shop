package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 02/04/2023 - 13:38
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${admin-auth}/payment")
@RequiredArgsConstructor
public class AdminPaymentController {
    private final PaymentServiceImpl paymentService;
}
