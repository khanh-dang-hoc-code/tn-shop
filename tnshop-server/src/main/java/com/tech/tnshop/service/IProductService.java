package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.dto.request.product.UpdateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IProductService {
    ResponseEntity<Object> getAllProducts(int index, int limit ,String brandId, String categoryId, String sortByPrice, String sortByCreateDate);
    ResponseEntity<Object> addNewProduct(AddNewProductRequest request);
    ResponseEntity<Object> updateProduct(UpdateProductRequest request);
    ResponseEntity<Object> deleteProduct(String idDelete);
    ResponseEntity<Object> removeListProduct(List<String> idsList);
    ResponseEntity<Object> getProduct(String id);

    ResponseEntity<Object> getListProductByCategory(String categoryId);
    ResponseEntity<Object> getListProductByBrand(String brandId);
}
