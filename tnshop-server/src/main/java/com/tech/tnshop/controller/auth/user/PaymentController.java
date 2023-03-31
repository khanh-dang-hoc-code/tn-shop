package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.entity.Order;
import com.tech.tnshop.service.serviceImpl.PaymentServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${user-auth}/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping("redirect")
    ResponseEntity<Object> createPaymentOrder(HttpServletRequest request) {
        Order order = new Order();
        return paymentService.checkoutToPaymentPage(request, order);
    }

    @GetMapping("/status")
    ResponseEntity<Object> updatePaymentAction(@RequestParam String sessionId) {
        return paymentService.updatePaymentAction(sessionId);
    }

    @PostMapping("refund")
    ResponseEntity<Object> refundOrderPayment(HttpServletRequest request) {
        return paymentService.refund( "");
    }
}
