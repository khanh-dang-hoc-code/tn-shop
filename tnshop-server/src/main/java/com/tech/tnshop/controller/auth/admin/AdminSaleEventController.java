package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.dto.request.saleEvent.AddNewSaleEventRequest;
import com.tech.tnshop.dto.request.saleEvent.RemoveListSaleEventRequest;
import com.tech.tnshop.dto.request.saleEvent.UpdateSaleEventRequest;
import com.tech.tnshop.service.impl.SaleEventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${admin-auth}/sale-event")
@RequiredArgsConstructor
public class AdminSaleEventController {
    private final SaleEventServiceImpl saleEventService;

    @GetMapping("/get")
    ResponseEntity<Object> getSaleEvent(@RequestParam String saleEventId) {
        return saleEventService.getSaleEvent(saleEventId);
    }

    @GetMapping("/get-list")
    ResponseEntity<Object> getListSaleEvent(@RequestParam int index, @RequestParam int limit) {
        return saleEventService.getAllSaleEvent(index, limit);
    }

    @PostMapping("/add")
    ResponseEntity<Object> addNewSaleEvent(@RequestBody AddNewSaleEventRequest request) {
        return saleEventService.addNewSaleEvent(request);
    }

    @PutMapping("/update")
    ResponseEntity<Object> updateSaleEvent(@RequestBody UpdateSaleEventRequest request) {
        return saleEventService.updateSaleEvent(request);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Object> deleteSaleEvent(@RequestParam String saleEventId) {
        return saleEventService.removeSaleEvent(saleEventId);
    }

    @DeleteMapping("/delete-list")
    ResponseEntity<Object> deleteSaleEventList(@RequestBody RemoveListSaleEventRequest request) {
        return saleEventService.removeListSaleEvent(request.getIds());
    }
}
