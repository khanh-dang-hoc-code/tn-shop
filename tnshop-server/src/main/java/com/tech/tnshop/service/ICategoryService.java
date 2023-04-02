package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.category.AddNewCategoryRequest;
import com.tech.tnshop.dto.request.category.UpdateCategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface ICategoryService {
    ResponseEntity<Object> createNewCategory(AddNewCategoryRequest request);
    ResponseEntity<Object> updateCategory(UpdateCategoryRequest request);
    ResponseEntity<Object> deleteCategory(String categoryId);
    ResponseEntity<Object> getAllCategory(int index, int limit);
    ResponseEntity<Object> getCategoryByID(String categoryId);

    ResponseEntity<Object> removeListCategory(List<String> idsList);

}
