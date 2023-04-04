package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.sale_event.AddNewSaleEventRequest;
import com.tech.tnshop.entity.SaleEvent;

import java.time.LocalDate;

/*
 * @created 02/04/2023 - 17:32
 * @project tn-shop
 * @author  ngockhanh
 */
public class SaleEventMapper {
    private SaleEventMapper () {

    }

    public static SaleEvent mapToSaleEventEntity(AddNewSaleEventRequest request) {
        return SaleEvent.builder()
                .startDate(LocalDate.parse(request.getStartDate()))
                .endDate(LocalDate.parse(request.getEndDate()))
                .saleOffValue(request.getSaleOffValue())
                .build();
    }
}
