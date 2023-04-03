package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.sale_event.AddNewSaleEventRequest;
import com.tech.tnshop.dto.request.sale_event.UpdateSaleEventRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface ISaleEventService {

    ResponseEntity<Object> addNewSaleEvent(AddNewSaleEventRequest request);
    ResponseEntity<Object> getSaleEvent(String saleEventId);
    ResponseEntity<Object> updateSaleEvent(UpdateSaleEventRequest request);
    ResponseEntity<Object> removeSaleEvent(String saleEventId);
    ResponseEntity<Object> removeListSaleEvent(List<String> saleEventListIds);
    ResponseEntity<Object> getAllSaleEvent(int index, int limit);


}
