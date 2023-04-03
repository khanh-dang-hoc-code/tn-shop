package com.tech.tnshop.repository;

import com.tech.tnshop.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IBrandRepository extends JpaRepository<Brand, String> {
    Page<Brand> findAll(Pageable pageable);
}
