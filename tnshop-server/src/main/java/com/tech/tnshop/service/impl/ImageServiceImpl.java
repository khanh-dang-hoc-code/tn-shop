package com.tech.tnshop.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tech.tnshop.dto.request.Image;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.exception.InternalServerException;
import com.tech.tnshop.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.bucket.name}")
    private  String bucketName;

    private static final UUID uuid = UUID.randomUUID();

    @Override
    public ResponseEntity<Object> uploadImages(MultipartFile file) {

        try {
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(file.getContentType());
                String uniqueKey = uuid.toString() + "-" + file.getOriginalFilename();

                amazonS3.putObject(new PutObjectRequest(bucketName, uniqueKey, file.getInputStream(), metadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
                String imageUrl = amazonS3.getUrl(bucketName, uniqueKey).toString();

            return ResponseEntity.ok(new AbstractResponse(new Image(uniqueKey, imageUrl)));
        } catch (IOException ex) {
            throw new InternalServerException("Error when upload image " + ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<Object> deleteImages(String imageKey) {
        try {
            amazonS3.deleteObject(bucketName, imageKey);
        } catch (Exception ex) {
            throw new InternalServerException("Dont exits image " + imageKey);
        }
        return ResponseEntity.ok(new MessageResponse("Delete image " + imageKey + " from aws bucket successfully"));
    }
}
