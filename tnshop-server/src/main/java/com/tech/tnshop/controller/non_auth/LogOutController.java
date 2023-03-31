package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
public class LogOutController {
    @GetMapping("/logout")
    public ResponseEntity<Object> logout() {
        return ResponseEntity.ok(new MessageResponse("Logout !!!"));
    }
}
