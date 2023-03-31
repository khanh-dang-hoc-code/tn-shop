package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.repository.ISaleEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class SaleEventServiceImpl {
    private final ISaleEventRepository repository;
}
