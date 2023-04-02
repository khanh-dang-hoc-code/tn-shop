package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.saleEvent.AddNewSaleEventRequest;
import com.tech.tnshop.entity.SaleEvent;

/*
 * @created 02/04/2023 - 17:32
 * @project tn-shop
 * @author  ngockhanh
 */
public class SaleEventMapper {

    public static SaleEvent mapToSaleEventEntity(AddNewSaleEventRequest request) {
        return SaleEvent.builder()
                .build();
    }
}
