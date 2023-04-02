package com.tech.tnshop.service;

import com.tech.tnshop.entity.ProfileImage;
import com.tech.tnshop.repository.IImageService;
import org.springframework.stereotype.Service;

/*
 * @created 02/04/2023 - 20:17
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IProfileImageService extends IImageService<ProfileImage> {
}
