package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.category.NewCategoryRequest;
import com.tech.tnshop.dto.request.category.UpdateCategoryRequest;
import com.tech.tnshop.entity.Brand;
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

@Component
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public ResponseEntity<Object> getAllCategory(int index, int limit) {
        Pageable pageable = PageRequest.of(index, limit, Sort.by("createDate").descending());
        Page<Category> categoryPages = categoryRepository.findAll(pageable);
        return ResponseEntity.ok(categoryPages.getContent());
    }

    @Override
    public ResponseEntity<Object> createNewCategory(NewCategoryRequest request) {
        return null;
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
        Category categoryDelete = findCategoryById(categoryId);
        categoryRepository.delete(categoryDelete);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public ResponseEntity<Object> getCategoryByID(String categoryId) {
        return ResponseEntity.ok(findCategoryById(categoryId));
    }

    @Override
    public ResponseEntity<Object> removeListCategory(List<String> idsList) {
        idsList.forEach(id -> {
            Category categoryDelete = findCategoryById(id);
            categoryRepository.delete(categoryDelete);
        });
        return ResponseEntity.ok("Delete successfully");
    }

    public Category findCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Can not find category " + categoryId));
    }
}
