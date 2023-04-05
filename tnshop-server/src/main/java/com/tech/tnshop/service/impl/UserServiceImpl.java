package com.tech.tnshop.service.impl;

import com.tech.tnshop.config.security.JwtService;
import com.tech.tnshop.config.security.SecurityConstants;
import com.tech.tnshop.dto.mapper.ProfileMapper;
import com.tech.tnshop.dto.mapper.UserMapper;
import com.tech.tnshop.dto.request.LoginRequest;
import com.tech.tnshop.dto.request.RegisterRequest;
import com.tech.tnshop.dto.request.ResetPasswordRequest;
import com.tech.tnshop.dto.response.AuthenticationResponse;
import com.tech.tnshop.entity.OTP;
import com.tech.tnshop.entity.Profile;
import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.BadRequestException;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.exception.UnauthorizedException;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.repository.IUserRepository;
import com.tech.tnshop.service.IUserService;
import com.tech.tnshop.shop_enum.RoleEnum;
import com.tech.tnshop.shop_enum.UserStatusEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticateService authenticateService;

    private final CartServiceImpl cartService;
    private final ProfileServiceImpl profileService;

    private final OTPService otpService;

    @Override
    public ResponseEntity<Object> createNewAccount(RegisterRequest registerRequest, String role) {
        User user = UserMapper.mapToUserEntity(registerRequest);
        OTP otp = otpService.getOTPByPhoneNumber(user.getUsername());
        if (!otp.isVerify()) {
            throw new UnauthorizedException("Please pass OTP verify before register");
        }
        Profile profile = ProfileMapper.mapFromRegisterRequest(registerRequest);
        user.setRole(role);
        user.setStatus(UserStatusEnum.ACTIVE.name());
        try {
            userRepository.save(user);
            profileService.createProfile(user, profile);
            cartService.createNewCart(user);
            otpService.resetOTPState(user.getUsername());
            String jwtToken = jwtService.generateToken(user);
            return  ResponseEntity.ok(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .expiredTime(String.valueOf(SecurityConstants.EXPIRATION_TIME))
                    .build());
        } catch (Exception ex) {
            String message = ShopHelper.validateObject(user);
            throw new BadRequestException(message);
        }
    }

    @Override
    public ResponseEntity<Object> login(LoginRequest loginRequest, String role) {
        String jwtToken = authenticateService.getTokenFromLoginInformation(loginRequest, role);
            return ResponseEntity.ok(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .expiredTime(String.valueOf(SecurityConstants.EXPIRATION_TIME))
                    .build());
    }

    @Override
    public ResponseEntity<Object> resetPassword(ResetPasswordRequest resetPasswordRequest) {
        User user = userRepository.findUserByUserName(resetPasswordRequest.getPhoneNumber())
                .orElseThrow(() -> new NotFoundException("Can not find user " + resetPasswordRequest.getPhoneNumber()));
        OTP otp = otpService.getOTPByPhoneNumber(user.getUsername());
        if (!otp.isVerify()) {
            throw new UnauthorizedException("Please pass OTP verify before reset password");
        }
        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));
        userRepository.save(user);
        otpService.resetOTPState(user.getUsername());
        return ResponseEntity.ok("Your password updated successfully");
    }

    @Override
    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow((() -> new NotFoundException("Can not find user " + userId)));
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName).orElseThrow((() -> new NotFoundException("Can not find user have " + userName)));
    }

    @Override
    public ResponseEntity<Object> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("Logout!!!");
    }


}
