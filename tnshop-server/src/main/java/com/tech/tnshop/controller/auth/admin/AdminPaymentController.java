package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.service.impl.PaymentServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/refund")
    ResponseEntity<Object> refund(@RequestParam String orderId) {
        return paymentService.refund(orderId);
    }

    @GetMapping("/day")
    ResponseEntity<Object> getAllPaymentInDay(HttpServletRequest request) {
        return paymentService.getAllPaymentInDay(request);
    }
    @GetMapping("/week")
    ResponseEntity<Object> getAllPaymentInWeek(HttpServletRequest request) {
        return paymentService.getAllPaymentInWeek(request);
    }
    @GetMapping("/month")
    ResponseEntity<Object> getAllPaymentInMonth(HttpServletRequest request) {
        return paymentService.getAllPaymentInWeek(request);
    }
    @GetMapping("/year")
    ResponseEntity<Object> getAllPaymentInYear(HttpServletRequest request) {
        return paymentService.getAllPaymentInWeek(request);
    }
}
