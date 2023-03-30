package com.tech.tnshop.service.serviceImpl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tech.tnshop.exception.InternalServerException;
import com.tech.tnshop.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.bucket.name}")
    private  String bucketName;

    @Override
    public ResponseEntity<Object> uploadImages(List<MultipartFile> files) {
        List<String> imageResponse = new ArrayList<>();
        try {
            for ( MultipartFile file : files
            ) {
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(file.getContentType());

                amazonS3.putObject(new PutObjectRequest(bucketName, file.getOriginalFilename(), file.getInputStream(), metadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
                String imageUrl = amazonS3.getUrl(bucketName, file.getOriginalFilename()).toString();
                imageResponse.add(imageUrl);
            }
            return ResponseEntity.ok(imageResponse);
        } catch (IOException ex) {
            throw new InternalServerException("Error when upload images");
        }
    }
}
