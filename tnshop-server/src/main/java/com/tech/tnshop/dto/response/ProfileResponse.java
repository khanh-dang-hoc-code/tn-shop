package com.tech.tnshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProfileResponse {
    private String firstName;

    private String lastName;

    private String telephoneNumber;
    private String avatarUrl;

    private LocalDate dateOfBirth;

    private String address1;

    private String address2;

    private String address3;
    private String email;
}
