package com.tech.tnshop.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandRequest {

    private String name;

    private String description;
}
