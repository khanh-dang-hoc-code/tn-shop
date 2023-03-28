package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.mapper.BrandMapper;
import com.tech.tnshop.dto.request.brand.AddNewBrandRequest;
import com.tech.tnshop.dto.request.brand.UpdateBrandRequest;
import com.tech.tnshop.entity.Brand;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.repository.IBrandRepository;
import com.tech.tnshop.service.IBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BrandServiceImpl implements IBrandService {
    private final IBrandRepository brandRepository;

    @Override
    public ResponseEntity<Object> getAllBrands(int index, int limit) {
        Pageable pageable = PageRequest.of(index, limit, Sort.by("createDate").descending());
        Page<Brand> brands = brandRepository.findAll(pageable);
        return ResponseEntity.ok(brands.getContent());
    }

    @Override
    public ResponseEntity<Object> addNewBrand(AddNewBrandRequest request) {
        Brand brand = BrandMapper.mapToBrand(request);
        brandRepository.save(brand);
        return ResponseEntity.ok("Add new brand successfully");
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
        return ResponseEntity.ok("update brand successfully");
    }

    @Override
    public ResponseEntity<Object> deleteBrand(String idDelete) {
        Brand brandDelete = findBrandById(idDelete);
        brandRepository.delete(brandDelete);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public ResponseEntity<Object> removeListBrand(List<String> idsList) {
        idsList.forEach(id -> {
            Brand brandDelete = findBrandById(id);
            brandRepository.delete(brandDelete);
        });
        return ResponseEntity.ok("Delete successfully");
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
