package com.tech.tnshop.repository;

import com.tech.tnshop.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP, String> {
    Optional<OTP> findOTPByPhoneNumber(String phoneNumber);
}
