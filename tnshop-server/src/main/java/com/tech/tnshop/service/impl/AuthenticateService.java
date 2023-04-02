package com.tech.tnshop.service.impl;

import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.BadRequestException;
import com.tech.tnshop.exception.UnauthorizedException;
import com.tech.tnshop.dto.request.LoginRequest;
import com.tech.tnshop.config.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class AuthenticateService {
    private final AuthenticationManager manager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;


    public String getTokenFromLoginInformation(LoginRequest loginRequest) {
        try {
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
            return jwtService.generateToken((UserDetails) authentication.getPrincipal());
        } catch (Exception e) {
            throw new BadRequestException("Username or password is not correct");
        }
    }

    private String getTokenFromAuthorize(HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Unauthorized");
        }
        return authHeader.substring(7);
    }

    public User getUserFromToken(HttpServletRequest request) {
        String jwtToken = getTokenFromAuthorize(request);
        if (jwtService.isTokenValid(jwtToken)) {
            String userName = jwtService.extractUsername(jwtToken);
            return (User) userDetailsService.loadUserByUsername(userName);
        }
        else {
            throw new BadRequestException("Token is not valid");
        }
    }

    public String getUserIdFromToken(HttpServletRequest request) {
        return getUserFromToken(request).getId();
    }
}
