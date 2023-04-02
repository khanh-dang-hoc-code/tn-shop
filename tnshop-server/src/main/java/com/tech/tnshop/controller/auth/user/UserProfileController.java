package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.ProfileRequest;
import com.tech.tnshop.service.serviceImpl.ProfileServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/profile")
@RequiredArgsConstructor
public class UserProfileController {
    private final ProfileServiceImpl profileService;

    @GetMapping("/get")
    public ResponseEntity<Object> getProfile(HttpServletRequest request) {
        return profileService.getProfileInformation(request);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProfile(HttpServletRequest servletRequest, @RequestBody ProfileRequest request) {
        return profileService.updateProfile(servletRequest, request);
    }
}
