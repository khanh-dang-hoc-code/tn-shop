package com.tech.tnshop.dto.request.orderItems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewOrderItemRequest {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("productId")
    private String productId;
    
    @JsonProperty("quantity")
    private int quantity;
}
