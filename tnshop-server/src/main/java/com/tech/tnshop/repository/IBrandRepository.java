package com.tech.tnshop.repository;

import com.tech.tnshop.entity.Brand;
import com.tech.tnshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, String> {
    Page<Brand> findAll(Pageable pageable);
}
