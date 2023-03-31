package com.tech.tnshop.dto.response;


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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponse {

    private String id;

    private String name;

    private String description;

    private LocalDate createDate;

    private LocalDate updateDate;
}
