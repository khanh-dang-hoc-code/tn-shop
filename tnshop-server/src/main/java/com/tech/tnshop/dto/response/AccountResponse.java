package com.tech.tnshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private String id;
    private String userName;
    private String password;
    private LocalDate createdDate;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
}
