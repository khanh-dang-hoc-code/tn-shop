package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.mapper.SaleEventMapper;
import com.tech.tnshop.dto.request.saleEvent.AddNewSaleEventRequest;
import com.tech.tnshop.dto.request.saleEvent.UpdateSaleEventRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.SaleEvent;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.ISaleEventRepository;
import com.tech.tnshop.service.ISaleEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class SaleEventServiceImpl implements ISaleEventService {
    private final ISaleEventRepository repository;

    @Override
    public ResponseEntity<Object> addNewSaleEvent(AddNewSaleEventRequest request) {
        SaleEvent saleEvent = SaleEventMapper.mapToSaleEventEntity(request);
        repository.save(saleEvent);
        return ResponseEntity.ok(new AbstractResponse(saleEvent));
    }

    @Override
    public ResponseEntity<Object> getSaleEvent(String saleEventId) {
        return ResponseEntity.ok(new AbstractResponse(findSaleEventById(saleEventId)));
    }

    @Override
    public ResponseEntity<Object> updateSaleEvent(UpdateSaleEventRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> removeSaleEvent(String saleEventId) {
        repository.deleteById(saleEventId);
        return ResponseEntity.ok(new MessageResponse("Remove sale events " + saleEventId + " successfully"));
    }

    @Override
    public ResponseEntity<Object> removeListSaleEvent(List<String> saleEventListIds) {
        repository.deleteAllById(saleEventListIds);
        return ResponseEntity.ok(new MessageResponse("Remove sale events successfully"));
    }

    @Override
    public ResponseEntity<Object> getAllSaleEvent(int index, int limit) {
        return null;
    }

    public SaleEvent findSaleEventById(String saleEventId) {
        return repository.findById(saleEventId)
                .orElseThrow(() -> new NotFoundException("Can not find sale event " + saleEventId));
    }
}
