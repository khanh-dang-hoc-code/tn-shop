package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.entity.Profile;
import com.tech.tnshop.entity.ProfileImage;
import com.tech.tnshop.repository.IProfileImageRepository;
import com.tech.tnshop.service.IProfileImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 02/04/2023 - 20:35
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class ProfileImageServiceImpl implements IProfileImageService {

    private final IProfileImageRepository repository;

    @Override
    public void saveImageToBrand(Profile profile, AddNewImageRequest request) {
        ProfileImage profileImage = ProfileImage.builder()
                .url(request.getUrl())
                .imageUrl(profile)
                .imageName(request.getName())
                .build();

        repository.save(profileImage);
    }

    @Override
    public void deleteImage(String imageName) {
        repository.deleteByImageName(imageName);
    }

    @Override
    public List<ProfileImage> getImages(String parentId) {
        return repository.getAllByProfileId(parentId);
    }
}
