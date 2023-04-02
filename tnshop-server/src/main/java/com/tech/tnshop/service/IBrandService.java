package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.brand.AddNewBrandRequest;
import com.tech.tnshop.dto.request.brand.UpdateBrandRequest;
import com.tech.tnshop.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public interface IBrandService {

    ResponseEntity<Object> getAllBrands(int index, int limit);
    ResponseEntity<Object> addNewBrand(AddNewBrandRequest request);
    ResponseEntity<Object> updateBrand(UpdateBrandRequest request);
    ResponseEntity<Object> deleteBrand(String idDelete);
    ResponseEntity<Object> removeListBrand(List<String> idsList);
    ResponseEntity<Object> getBrand(String id);
}
