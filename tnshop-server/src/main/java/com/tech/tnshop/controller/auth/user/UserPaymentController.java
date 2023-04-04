package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.service.impl.PaymentServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/payment")
@RequiredArgsConstructor
public class UserPaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping("/redirect")
    ResponseEntity<Object> createPaymentOrder(HttpServletRequest request,@RequestParam String orderId) {
        return paymentService.checkoutToPaymentPage(request, orderId);
    }
}
