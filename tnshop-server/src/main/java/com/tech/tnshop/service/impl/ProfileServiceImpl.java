package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.Profile;
import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.BadRequestException;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.dto.mapper.ProfileMapper;
import com.tech.tnshop.dto.request.ProfileRequest;
import com.tech.tnshop.dto.response.ProfileResponse;
import com.tech.tnshop.repository.IProfileRepository;
import com.tech.tnshop.service.IProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class ProfileServiceImpl implements IProfileService {
    private final AuthenticateService authenticateService;
    private final IProfileRepository profileRepository;

    private final ProfileImageServiceImpl profileImageService;

    @Override
    public ResponseEntity<Object> getProfileInformation(HttpServletRequest request) {
        String userId = authenticateService.getUserIdFromToken(request);
        if (StringHelper.isEmpty(userId)) {
           throw new BadRequestException("The user id can be not null");
        }
        Profile profile =  profileRepository.getProfileByUser(userId).orElseThrow(() -> new NotFoundException("User" + userId + " not found"));
        ProfileResponse response = ProfileMapper.mapToProfileResponse(profile);
        return ResponseEntity.ok(new AbstractResponse(response));
    }

    @Override
    public ResponseEntity<Object> updateProfile(HttpServletRequest servletRequest, ProfileRequest profileRequest) {
        Profile profileUpdate  = ProfileMapper.mapToProfileEntity(profileRequest);
        String userId = authenticateService.getUserIdFromToken(servletRequest);
        Profile currentProfile =  profileRepository.getProfileByUser(userId).orElseThrow(() -> new NotFoundException("User" + userId + " not found"));

            profileRepository.save(currentProfile);
            profileRequest.getImageList().forEach(s -> profileImageService.saveImageToBrand(profileUpdate, new AddNewImageRequest("", s.getName(), s.getUrl())));

        return ResponseEntity.ok(new MessageResponse("Updated sucessfully"));
    }

    @Override
    public ResponseEntity<Object> createProfile(User user, Profile profile) {
        try {
            profile.setUser(user);
            profileRepository.save(profile);
            return ResponseEntity.ok(new MessageResponse("success"));
        } catch (Exception ex) {
            throw new BadRequestException("Invalid profile request");
        }
    }
}
