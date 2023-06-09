package com.tech.tnshop.repository;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 02/04/2023 - 20:28
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IImageService<T, E> {
    void saveImageToBrand(E t, AddNewImageRequest request);
    void deleteImage(String imageName);
    List<T> getImages(String parentId);
}
