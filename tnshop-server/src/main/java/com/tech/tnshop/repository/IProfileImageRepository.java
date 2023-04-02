package com.tech.tnshop.repository;

import com.tech.tnshop.entity.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT * FROM shop_service.profile_image WHERE profile_id = :profileId", nativeQuery = true)
    List<ProfileImage> getAllByProfileId(@Param("profileId") String profileId);
}
