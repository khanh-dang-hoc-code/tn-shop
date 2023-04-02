package com.tech.tnshop.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImageService {
    ResponseEntity<Object> uploadImages(MultipartFile files);

    ResponseEntity<Object> deleteImages(String imageKey);
}
