package com.tech.tnshop.dto.request.cart;

import lombok.Data;

import java.util.List;

@Data
public class RemoveListProductCartRequest {
    private List<String> idsDelete;
}
