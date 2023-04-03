package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.entity.Brand;
import com.tech.tnshop.entity.BrandImage;
import com.tech.tnshop.repository.IBrandImageRepository;
import com.tech.tnshop.service.IBrandImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 02/04/2023 - 20:32
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class IBrandImageServiceImpl implements IBrandImageService {

    private final IBrandImageRepository repository;

    @Override
    public void saveImageToBrand(Brand brand, AddNewImageRequest request) {
        BrandImage brandImage = BrandImage.builder()
                .url(request.getUrl())
                .imageName(request.getName())
                .imageUrl(brand)
                .build();

        repository.save(brandImage);
    }

    @Override
    public void deleteImage(String imageName) {
        repository.deleteByImageName(imageName);
    }

    @Override
    public List<BrandImage> getImages(String parentId) {
        return repository.getAllByBrandId(parentId);
    }
}
