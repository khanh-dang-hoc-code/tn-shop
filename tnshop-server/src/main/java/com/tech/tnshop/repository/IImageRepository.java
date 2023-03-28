package com.tech.tnshop.repository;

import com.tech.tnshop.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<Images, String> {
}
