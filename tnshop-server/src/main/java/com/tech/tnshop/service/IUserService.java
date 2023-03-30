package com.tech.tnshop.service;

import com.tech.tnshop.entity.User;
import com.tech.tnshop.dto.request.LoginRequest;
import com.tech.tnshop.dto.request.RegisterRequest;
import com.tech.tnshop.dto.request.ResetPasswordRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

     ResponseEntity<Object> createNewAccount(RegisterRequest registerRequest, String role);
     ResponseEntity<Object> login (LoginRequest loginRequest);
     ResponseEntity<Object> resetPassword(ResetPasswordRequest resetPasswordRequest, HttpServletRequest servletRequest);

     User findUserById(String userId);
     User findUserByUserName(String userName);

     ResponseEntity<Object> logout(HttpServletRequest request);
}
