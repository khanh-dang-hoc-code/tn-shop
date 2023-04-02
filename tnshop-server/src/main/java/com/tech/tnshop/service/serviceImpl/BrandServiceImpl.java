package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.mapper.BrandMapper;
import com.tech.tnshop.dto.request.brand.AddNewBrandRequest;
import com.tech.tnshop.dto.request.brand.UpdateBrandRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.Brand;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.repository.IBrandRepository;
import com.tech.tnshop.service.IBrandService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sql.internal.SQLQueryParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class BrandServiceImpl implements IBrandService {
    private final IBrandRepository brandRepository;

    @Override
    public ResponseEntity<Object> getAllBrands(int index, int limit) {
        Pageable pageable = PageRequest.of(index, limit, Sort.by("createDate").descending());
        Page<Brand> brands = brandRepository.findAll(pageable);
        return ResponseEntity.ok(new AbstractResponse(brands.getContent()));
    }

    @Override
    public ResponseEntity<Object> addNewBrand(AddNewBrandRequest request) {
        Brand brand = BrandMapper.mapToBrand(request);
        brandRepository.save(brand);
        return ResponseEntity.ok(new AbstractResponse(brand));
    }

    @Override
    public ResponseEntity<Object> updateBrand(UpdateBrandRequest request) {
        Brand brand = findBrandById(request.getId());
        if (StringHelper.isNotEmpty(request.getName())) {
            brand.setName(request.getName());
        }
        if (StringHelper.isNotEmpty(request.getDescription())) {
            brand.setDescription(request.getDescription());
        }
        brandRepository.save(brand);
        return ResponseEntity.ok(new MessageResponse("Update brand successfully"));
    }

    @Override
    public ResponseEntity<Object> deleteBrand(String idDelete) {
        brandRepository.deleteById(idDelete);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public ResponseEntity<Object> removeListBrand(List<String> idsList) {
        brandRepository.deleteAllById(idsList);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public ResponseEntity<Object> getBrand(String id) {
        return ResponseEntity.ok(findBrandById(id));
    }

    public Brand findBrandById(String id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find brand " + id));
    }
}
