package com.tech.tnshop.controller.non_auth;


import com.tech.tnshop.service.serviceImpl.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/non-auth/mail")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;
    private final JavaMailSender javaMailSender;



}
