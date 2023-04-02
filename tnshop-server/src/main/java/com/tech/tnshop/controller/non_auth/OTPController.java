package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.dto.request.GetOTPRequest;
import com.tech.tnshop.dto.request.VerifyOTPRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.impl.EmailService;
import com.tech.tnshop.service.impl.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${no-auth}/notification")
public class OTPController {

    private final OTPService otpService;
    private final EmailService emailService;

    @GetMapping("/send-otp")
    public ResponseEntity<Object> sendOtp(@RequestBody GetOTPRequest request) {
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
        emailService.sendEmail();
    }
}
