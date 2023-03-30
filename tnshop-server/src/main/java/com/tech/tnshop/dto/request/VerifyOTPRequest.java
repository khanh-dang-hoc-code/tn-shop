package com.tech.tnshop.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class VerifyOTPRequest {
    @NotNull
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @NotNull
    @JsonProperty("OTPCode")
    private String otpCode;
}
