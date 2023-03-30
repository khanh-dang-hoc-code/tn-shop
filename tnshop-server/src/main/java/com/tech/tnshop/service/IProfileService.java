package com.tech.tnshop.service;

import com.tech.tnshop.entity.Profile;
import com.tech.tnshop.dto.request.ProfileRequest;
import com.tech.tnshop.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IProfileService {
    ResponseEntity<Object> getProfileInformation(HttpServletRequest request);
    ResponseEntity<Object> updateProfile(HttpServletRequest servletRequest, ProfileRequest profileRequest);

    ResponseEntity<Object> createProfile(User user, Profile profile);

}
