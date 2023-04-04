package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.service.impl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${no-auth}/resource")
@RequiredArgsConstructor
public class ImageController {

    private final ImageServiceImpl imageService;


    @PostMapping("/upload-image")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file) {
        return imageService.uploadImages(file);
    }

    @DeleteMapping("/delete-image")
    public ResponseEntity<Object> delete(@RequestParam String imageName) {
        return imageService.deleteImages(imageName);
    }
}
