package com.tech.tnshop.repository;

import com.tech.tnshop.entity.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 02/04/2023 - 20:14
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IProfileImageRepository extends JpaRepository<ProfileImage, String> {

    void deleteByImageName(String imageName);

    List<ProfileImage> getAllByProfileImage(String profileImageId);
}
