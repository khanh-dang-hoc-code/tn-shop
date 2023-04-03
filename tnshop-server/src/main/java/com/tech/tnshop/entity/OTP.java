package com.tech.tnshop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Entity
@Table(name = "otp")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OTP {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    @Column(unique = true)
    private String phoneNumber;

    @Column
    private String otpCode;

    @Column
    private boolean isVerify;

    @Column
    private Long timeSend;

    public OTP(String formattedPhoneNumber, String otpCode) {
        phoneNumber = formattedPhoneNumber;
        this.otpCode = otpCode;
        isVerify = false;
        timeSend = System.currentTimeMillis();
    }
}
