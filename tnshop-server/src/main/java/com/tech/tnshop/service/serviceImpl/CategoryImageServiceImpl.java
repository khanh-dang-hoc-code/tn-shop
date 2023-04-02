package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.entity.BrandImage;
import com.tech.tnshop.entity.CategoryImage;
import com.tech.tnshop.repository.ICategoryImageRepository;
import com.tech.tnshop.service.ICategoryImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 02/04/2023 - 20:33
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class CategoryImageServiceImpl implements ICategoryImageService {

    private final ICategoryImageRepository repository;
    @Override
    public void saveImageToBrand(AddNewImageRequest request) {
        CategoryImage categoryImage = CategoryImage.builder()
                .url(request.getUrl())
                .imageName(request.getName())
                .build();

        repository.save(categoryImage);
    }

    @Override
    public void deleteImage(String imageName) {
        repository.deleteByImageName(imageName);
    }

    @Override
    public List<CategoryImage> getImages(String parentId) {
        return repository.getAllByCategoryImage(parentId);
    }
}
