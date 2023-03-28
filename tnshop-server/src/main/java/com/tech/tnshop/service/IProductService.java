package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.dto.request.product.UpdateProductRequest;
import com.tech.tnshop.entity.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    ResponseEntity<Object> getAllProducts(int index, int limit);
    ResponseEntity<Object> addNewProduct(AddNewProductRequest request);
    ResponseEntity<Object> updateProduct(UpdateProductRequest request);
    ResponseEntity<Object> deleteProduct(String idDelete);
    ResponseEntity<Object> removeListProduct(List<String> idsList);
    ResponseEntity<Object> getProduct(String id);
    void addCartToProduct (Cart cart, String productId);
    void removeCartToProduct (Cart cart, String productId);
}
