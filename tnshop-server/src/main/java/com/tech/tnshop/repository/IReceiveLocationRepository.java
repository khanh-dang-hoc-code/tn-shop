package com.tech.tnshop.repository;

import com.tech.tnshop.entity.ReceiveLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiveLocationRepository extends JpaRepository<ReceiveLocation, String> {
}
