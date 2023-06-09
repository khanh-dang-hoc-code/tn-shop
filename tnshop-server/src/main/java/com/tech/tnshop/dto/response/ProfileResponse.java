package com.tech.tnshop.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
