package com.tech.tnshop.dto.request.cart;

import lombok.Data;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
public class RemoveListProductCartRequest {
    private List<String> idsDelete;
}
