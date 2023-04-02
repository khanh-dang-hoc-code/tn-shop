package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.entity.Product;
import com.tech.tnshop.entity.ProductImage;
import com.tech.tnshop.repository.IProductImageRepository;
import com.tech.tnshop.service.IProductImageService;
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
public class ProductImageServiceImpl implements IProductImageService {

    private final IProductImageRepository repository;


    @Override
    public void saveImageToBrand(Product product, AddNewImageRequest request) {
        ProductImage productImage = ProductImage.builder()
                .imageName(request.getName())
                .url(request.getUrl())
                .productImage(product)
                .build();

        repository.save(productImage);
    }

    @Override
    public void deleteImage(String imageName) {
        repository.deleteByImageName(imageName);
    }

    @Override
    public List<ProductImage> getImages(String parentId) {
        return repository.getAllByProductImage(parentId);
    }
}
