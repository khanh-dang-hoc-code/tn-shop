package com.tech.tnshop.repository;

import com.tech.tnshop.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, String> {

    List<Payment> findAllByCreatedAtAfter(LocalDate today);

    @Query(value = "SELECT * FROM shop_service.payment WHERE DATE(create_at) = CURDATE()", nativeQuery = true)
    List<Payment> getAllPaymentInAWeek();
}
