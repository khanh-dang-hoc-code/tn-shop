package com.tech.tnshop.controller.auth.admin;

/*
 * @created 01/04/2023 - 09:37
 * @project tn-shop
 * @author  ngockhanh
 */

import com.tech.tnshop.dto.request.ProfileRequest;
import com.tech.tnshop.service.serviceImpl.ProfileServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${admin-auth}/profile")
@RequiredArgsConstructor
public class AdminProfileController {
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
