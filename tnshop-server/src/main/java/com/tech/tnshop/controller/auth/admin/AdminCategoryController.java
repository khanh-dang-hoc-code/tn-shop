package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.dto.request.category.AddNewCategoryRequest;
import com.tech.tnshop.dto.request.category.RemoveListCategoryRequest;
import com.tech.tnshop.dto.request.category.UpdateCategoryRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.serviceImpl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 09:37
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${admin-auth}/category")
@RequiredArgsConstructor
public class AdminCategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping("/get")
    public ResponseEntity<Object> getCategory(@RequestParam String categoryId) {
        return categoryService.getCategoryByID(categoryId);
    }

    @GetMapping("/get-list")
    public ResponseEntity<Object> getListCategory(@RequestParam int index, @RequestParam int limit) {
        return categoryService.getAllCategory(index, limit);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewCategory(@RequestBody AddNewCategoryRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return categoryService.createNewCategory(request);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCategory(@RequestBody UpdateCategoryRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return categoryService.updateCategory(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCategory(@RequestParam String categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @DeleteMapping("/delete-list")
    public ResponseEntity<Object> deleteCategory(@RequestBody RemoveListCategoryRequest request) {
        return categoryService.removeListCategory(request.getCategoriesId());
    }
}
