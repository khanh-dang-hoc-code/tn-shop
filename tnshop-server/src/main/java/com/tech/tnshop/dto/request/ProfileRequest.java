package com.tech.tnshop.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileRequest {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("avatarUrl")

    private String avatarUrl;
    @JsonProperty("telephoneNumber")
    private String telephoneNumber;
    @JsonProperty("dateOfBirth")
    private LocalDate dateOfBirth;
    @JsonProperty("address1")

    private String address1;
    @JsonProperty("address2")
    private String address2;

    @JsonProperty("address3")
    private String address3;
}
