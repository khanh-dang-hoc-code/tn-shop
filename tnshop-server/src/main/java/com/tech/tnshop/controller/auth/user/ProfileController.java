package com.tech.tnshop.controller.auth.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/force-auth/user/profile")
public class ProfileController {
    @GetMapping
    public ResponseEntity<Object> getUserProfile() {
        System.out.println("Profile");
        return ResponseEntity.ok("user profile");
    }
}
