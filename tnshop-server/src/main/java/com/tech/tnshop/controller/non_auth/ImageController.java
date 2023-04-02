package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.service.serviceImpl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("${no-auth}/resource")
@RequiredArgsConstructor
public class ImageController {

    private final ImageServiceImpl imageService;


    @PostMapping("/upload-image")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.uploadImages(file);
    }
}
