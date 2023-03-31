package com.tech.tnshop.repository;

import com.tech.tnshop.entity.SaleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface ISaleEventRepository extends JpaRepository<SaleEvent, String> {
}
