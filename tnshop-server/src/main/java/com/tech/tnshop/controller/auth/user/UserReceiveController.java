package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.service.impl.ReceiveLocationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
