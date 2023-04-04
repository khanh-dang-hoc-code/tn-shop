package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.dto.request.LoginRequest;
import com.tech.tnshop.dto.request.RegisterRequest;
import com.tech.tnshop.dto.request.ResetPasswordRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.impl.UserServiceImpl;
import com.tech.tnshop.shop_enum.RoleEnum;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("${no-auth}/user/")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest) {
        ShopHelper.validateObjectRequiredFields(registerRequest);
        String role = RoleEnum.USER_ROLE.name();
        return userService.createNewAccount(registerRequest, role);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        ShopHelper.validateObjectRequiredFields(loginRequest);
        return userService.login(loginRequest);
    }

    @PostMapping(value = "/reset-password")
    public ResponseEntity<Object> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest ) {
        ShopHelper.validateObjectRequiredFields(resetPasswordRequest);
        return userService.resetPassword(resetPasswordRequest);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request) {
        return userService.logout(request);
    }

}
