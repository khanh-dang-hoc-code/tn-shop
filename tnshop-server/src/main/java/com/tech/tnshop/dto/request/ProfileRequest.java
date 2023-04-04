package com.tech.tnshop.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileRequest {

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;
    @JsonProperty

    private String avatarUrl;
    @JsonProperty
    private String telephoneNumber;
    @JsonProperty
    private String dateOfBirth;
    @JsonProperty

    private String address1;
    @JsonProperty
    private String address2;

    @JsonProperty
    private String address3;

    @JsonProperty
    private List<Image> imageList;
}
