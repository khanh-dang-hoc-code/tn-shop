package com.tech.tnshop.repository;

import com.tech.tnshop.entity.SaleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleEventRepository extends JpaRepository<SaleEvent, String> {
}
