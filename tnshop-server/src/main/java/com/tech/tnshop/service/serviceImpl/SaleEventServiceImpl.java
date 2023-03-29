package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.repository.ISaleEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaleEventServiceImpl {
    private final ISaleEventRepository repository;
}
