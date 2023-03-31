package com.tech.tnshop.repository;


import com.tech.tnshop.entity.Category;
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
public interface ICategoryRepository extends JpaRepository<Category, String> {
    Page<Category> findAll(Pageable pageable);
}
