package com.tech.tnshop.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

    @NotNull
    @JsonProperty
    private String firstName;
    @NotNull
    @JsonProperty
    private String lastName;
    @NotNull
    @JsonProperty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password is not valid, It must be at least 8 characters long. " +
                    "It must contain at least one lowercase letter, one uppercase letter, one digit, and one special character")
    private String password;

    @NotNull
    @JsonProperty
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Email is not valid")
    private String email;
    @NotNull
    @JsonProperty
    @Pattern(regexp = "^(\\+84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8|9]|9[0-4|6-9])(\\d{7})$", message = "Incorrect phone number format")
    private String userName;


}
