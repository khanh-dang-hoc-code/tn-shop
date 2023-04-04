package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.AddNewReceiveLocationRequest;
import com.tech.tnshop.dto.request.UpdateReceiveLocationRequest;
import com.tech.tnshop.service.impl.ReceiveLocationServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 09:38
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/receive-location")
@RequiredArgsConstructor
public class UserReceiveController {
    private final ReceiveLocationServiceImpl service;


    @PostMapping("/add")
    ResponseEntity<Object> addNewReceiveLocation(HttpServletRequest servletRequest, AddNewReceiveLocationRequest request) {
        return service.addNewReceiveLocation(servletRequest, request);
    }
    @PutMapping("/update")
    ResponseEntity<Object> updateReceiveLocation(HttpServletRequest servletRequest, UpdateReceiveLocationRequest request) {
        return service.updateReceiveLocation(servletRequest, request);
    }
    @DeleteMapping("/delete")
    ResponseEntity<Object> removeReceiveLocation(HttpServletRequest servletRequest,  String receiveLocationId) {
        return service.removeReceiveLocation(servletRequest, receiveLocationId);
    }
    @PostMapping("/delete-all")
    ResponseEntity<Object> getAllReceiveLocation(HttpServletRequest servletRequest) {
        return service.getAllReceiveLocation(servletRequest);
    }
}
