package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.mapper.CategoryMapper;
import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.dto.request.category.AddNewCategoryRequest;
import com.tech.tnshop.dto.request.category.UpdateCategoryRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.entity.Category;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.repository.ICategoryRepository;
import com.tech.tnshop.service.ICategoryService;
import lombok.RequiredArgsConstructor;
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
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    private final CategoryImageServiceImpl categoryImageService;

    @Override
    public ResponseEntity<Object> getAllCategory(int index, int limit) {
        Pageable pageable = PageRequest.of(index, limit, Sort.by("createDate").descending());
        Page<Category> categoryPages = categoryRepository.findAll(pageable);
        return ResponseEntity.ok(categoryPages.getContent());
    }

    @Override
    public ResponseEntity<Object> createNewCategory(AddNewCategoryRequest request) {
        Category category = CategoryMapper.mapToCategoryEntity(request);
        categoryRepository.save(category);
        request.getImageList().forEach(s ->
            categoryImageService.saveImageToBrand(category, new AddNewImageRequest("", s.getName(), s.getUrl())));
        return ResponseEntity.ok(new AbstractResponse(category));
    }

    @Override
    public ResponseEntity<Object> updateCategory(UpdateCategoryRequest request) {
        Category categoryUpdate = findCategoryById(request.getId());

        if (StringHelper.isNotEmpty(request.getName())) {
            categoryUpdate.setName(request.getName());
        }
        if (StringHelper.isNotEmpty(request.getDescription())) {
            categoryUpdate.setDescription(request.getDescription());
        }
        categoryRepository.save(categoryUpdate);
        return ResponseEntity.ok("Category updated successfully");
    }

    @Override
    public ResponseEntity<Object> deleteCategory(String categoryId) {
        categoryRepository.deleteById(categoryId);
        return ResponseEntity.ok("Delete category " + categoryId + " successfully");
    }

    @Override
    public ResponseEntity<Object> getCategoryByID(String categoryId) {
        return ResponseEntity.ok(findCategoryById(categoryId));
    }

    @Override
    public ResponseEntity<Object> removeListCategory(List<String> idsList) {
        categoryRepository.deleteAllById(idsList);
        return ResponseEntity.ok("Delete successfully");
    }

    public Category findCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Can not find category " + categoryId));
    }
}
