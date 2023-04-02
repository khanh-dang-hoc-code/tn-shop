package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.AddNewReceiveLocationRequest;
import com.tech.tnshop.dto.request.UpdateReceiveLocationRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IReceiveLocationService {
    ResponseEntity<Object> addNewReceiveLocation(HttpServletRequest servletRequest, AddNewReceiveLocationRequest request);
    ResponseEntity<Object> updateReceiveLocation(HttpServletRequest servletRequest, UpdateReceiveLocationRequest request);
    ResponseEntity<Object> removeReceiveLocation(HttpServletRequest servletRequest,  String receiveLocationId);
    ResponseEntity<Object> getAllReceiveLocation(HttpServletRequest servletRequest);

}
