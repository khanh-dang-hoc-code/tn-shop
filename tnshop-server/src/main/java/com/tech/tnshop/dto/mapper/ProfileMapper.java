package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.entity.Profile;
import com.tech.tnshop.dto.request.ProfileRequest;
import com.tech.tnshop.dto.request.RegisterRequest;
import com.tech.tnshop.dto.response.ProfileResponse;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class ProfileMapper {
    private ProfileMapper () {

    }
    public static Profile mapToProfileEntity(ProfileRequest profileRequest) {
        return Profile.builder()
                .firstName(profileRequest.getFirstName())
                .lastName(profileRequest.getLastName())
                .address1(profileRequest.getAddress1())
                .address2(profileRequest.getAddress2())
                .address3(profileRequest.getAddress3())
                .dateOfBirth(profileRequest.getDateOfBirth())
                .telephoneNumber(profileRequest.getTelephoneNumber())
                .build();
    }

    public static ProfileResponse mapToProfileResponse(Profile profile) {
        return ProfileResponse.builder()
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .address1(profile.getAddress1())
                .address2(profile.getAddress2())
                .address3(profile.getAddress3())
                .dateOfBirth(profile.getDateOfBirth())
                .email(profile.getEmail())
                .telephoneNumber(profile.getTelephoneNumber())
                .build();
    }

    public static Profile mapFromRegisterRequest(RegisterRequest registerRequest) {
        return Profile.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .telephoneNumber(registerRequest.getUserName())
                .email(registerRequest.getEmail())
                .build();
    }
}
