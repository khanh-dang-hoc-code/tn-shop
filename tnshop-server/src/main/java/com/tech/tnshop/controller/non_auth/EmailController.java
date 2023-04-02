package com.tech.tnshop.controller.non_auth;


import com.tech.tnshop.service.impl.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${no-auth}/mail")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;
    private final JavaMailSender javaMailSender;



}
