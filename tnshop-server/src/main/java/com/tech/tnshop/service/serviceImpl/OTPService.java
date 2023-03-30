package com.tech.tnshop.service.serviceImpl;


import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.tech.tnshop.entity.OTP;
import com.tech.tnshop.exception.BadRequestException;
import com.tech.tnshop.exception.InternalServerException;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.OTPRepository;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OTPService {

    private Long timeExpiredOTPCode = 180000L;

    private final TwilioRestClient twilioRestClient;

    private PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    private final OTPRepository otpRepository;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    public ResponseEntity<Object> sendOtp(String phoneNumber) throws Exception {
        try {
            String otpCode = String.valueOf(new Random().nextInt(900000) + 100000);
            String formattedPhoneNumber = convertPhoneNumberToTwillioPhoneNumber(phoneNumber);
            String message = "Thanks you for using TNShop service. Your OTP is : " + otpCode;

            Optional<OTP> otpOptional = otpRepository.findOTPByPhoneNumber(formattedPhoneNumber);
            OTP otp;
            if (otpOptional.isPresent()) {
                otp =  otpOptional.get();
                otp.setVerify(false);
                otp.setTimeSend(System.currentTimeMillis());
                otp.setOTPCode(otpCode);

            } else {
                 otp = new OTP(formattedPhoneNumber, otpCode);
            }
            otpRepository.save(otp);
            Message.creator(
                    new PhoneNumber(formattedPhoneNumber),
                    new PhoneNumber(twilioPhoneNumber),
                    message).create(twilioRestClient);


            return ResponseEntity.ok("send otp successfully");

        } catch (Exception e){
            throw new InternalServerException("Error when send OTP");
        }
    }

    public ResponseEntity<Object> validateOTP(String otpCode, String phoneNumber) {
        String formattedPhoneNumber = convertPhoneNumberToTwillioPhoneNumber(phoneNumber);

        OTP otp = getOTPByPhoneNumber(formattedPhoneNumber);

        if (otpCode.equalsIgnoreCase(otp.getOTPCode()) && otp.getTimeSend() >= System.currentTimeMillis() - timeExpiredOTPCode) {
            otp.setVerify(true);
            otpRepository.save(otp);
                return ResponseEntity.ok("Your otp code is successfully");
        } else {
            throw new BadRequestException("Your OTP is not correct or invalid. Pls try again!!!");
        }
    }

    public OTP getOTPByPhoneNumber(String phoneNumber) {
        String phoneNumberFormatter = convertPhoneNumberToTwillioPhoneNumber(phoneNumber);
        return otpRepository.findOTPByPhoneNumber(phoneNumberFormatter)
                .orElseThrow(() -> new NotFoundException("Please verify this phone number: "+ phoneNumber));
    }

    private String convertPhoneNumberToTwillioPhoneNumber(String normalPhoneNumber) {
        String formattedPhoneNumber = "";
        try {
            Phonenumber.PhoneNumber phoneNumberValue = phoneNumberUtil.parse(normalPhoneNumber, "VN");
            formattedPhoneNumber = phoneNumberUtil.format(phoneNumberValue, PhoneNumberUtil.PhoneNumberFormat.E164);
        }catch (Exception e) {
            throw new BadRequestException("Phone number is not correct");
        }
        return formattedPhoneNumber;
    }

    public void resetOTPState(String phoneNumber) {
        OTP otp = getOTPByPhoneNumber(phoneNumber);
        otp.setVerify(false);
        otpRepository.save(otp);
    }
}
