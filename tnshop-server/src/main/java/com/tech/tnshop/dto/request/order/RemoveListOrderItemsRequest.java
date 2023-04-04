package com.tech.tnshop.dto.request.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoveListOrderItemsRequest {

    @JsonProperty
    private List<String> ids;
}
