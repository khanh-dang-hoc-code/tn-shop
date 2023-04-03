package com.tech.tnshop.dto.request.sale_event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
 * @created 02/04/2023 - 17:27
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewSaleEventRequest {

    @JsonProperty
    private LocalDate startDate;
}
