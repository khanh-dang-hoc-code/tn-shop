package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.request.AddNewReceiveLocationRequest;
import com.tech.tnshop.dto.request.UpdateReceiveLocationRequest;
import com.tech.tnshop.service.IReceiveLocationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class ReceiveLocationServiceImpl implements IReceiveLocationService {
    @Override
    public ResponseEntity<Object> addNewReceiveLocation(HttpServletRequest servletRequest, AddNewReceiveLocationRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateReceiveLocation(HttpServletRequest servletRequest, UpdateReceiveLocationRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> removeReceiveLocation(HttpServletRequest servletRequest, String receiveLocationId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getAllReceiveLocation(HttpServletRequest servletRequest) {
        return null;
    }
}
