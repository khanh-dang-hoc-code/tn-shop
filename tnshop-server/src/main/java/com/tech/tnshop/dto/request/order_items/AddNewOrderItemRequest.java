package com.tech.tnshop.dto.request.order_items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewOrderItemRequest {

    @JsonProperty
    private String orderId;

    private String cartId;

    @JsonProperty
    private String productId;
    
    @JsonProperty
    private int quantity;
}
