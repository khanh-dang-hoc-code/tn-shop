package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.dto.request.GetOTPRequest;
import com.tech.tnshop.dto.request.VerifyOTPRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.serviceImpl.EmailService;
import com.tech.tnshop.service.serviceImpl.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequiredArgsConstructor
@RequestMapping("${no-auth}/notification")
public class OTPController {

    private final OTPService otpService;
    private final EmailService emailService;

    @GetMapping("/send-otp")
    public ResponseEntity<Object> sendOtp(@RequestBody GetOTPRequest request) throws Exception {
        ShopHelper.validateObjectRequiredFields(request);
        return otpService.sendOtp(request.getPhoneNumber());
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<Object>  verifyOTP(@RequestBody VerifyOTPRequest otpRequest) {
        ShopHelper.validateObjectRequiredFields(otpRequest);
        return otpService.validateOTP(otpRequest.getOtpCode() , otpRequest.getPhoneNumber());
    }

    @GetMapping("/send-email")
    public void sendEmail() throws IOException {
        String to = "khanhkhanhitit@gmail.com";
        String subject = "Test email";
        String body = "This is a test email sent with SendGrid.";
        emailService.sendEmail();
        System.out.println("send success");
    }
}
