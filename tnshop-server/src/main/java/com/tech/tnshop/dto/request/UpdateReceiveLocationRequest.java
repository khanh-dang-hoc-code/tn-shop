package com.tech.tnshop.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/*
 * @created 03/04/2023 - 04:48
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateReceiveLocationRequest {
    private String address;
}
