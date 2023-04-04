package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.mapper.ProductMapper;
import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.dto.request.product.UpdateProductRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.Brand;
import com.tech.tnshop.entity.Category;
import com.tech.tnshop.entity.Product;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.repository.IProductRepository;
import com.tech.tnshop.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final BrandServiceImpl brandService;
    private final CategoryServiceImpl categoryService;
    private final ProductImageServiceImpl imageService;


    @Override
    public ResponseEntity<Object> getAllProducts(String categoryId, String brandId, int index, int limit,String sortByName,
                                                 String sortByPrice, String sortByCreateDate, String saleEventId, String color, String size) {
        List<Product> products = productRepository.pagenation(categoryId, brandId, index, limit, sortByName, sortByPrice, sortByCreateDate, saleEventId, color, size);
        return ResponseEntity.ok(new AbstractResponse(products));
    }

    @Override
    public ResponseEntity<Object> addNewProduct(AddNewProductRequest request) {
        Product product = ProductMapper.mapToProduct(request);
        Brand brand = brandService.findBrandById(request.getBrandId());
        Category category = categoryService.findCategoryById(request.getCategoryId());
        product.setBrand(brand);
        product.setCategoryProduct(category);
        productRepository.save(product);
        request.getImageList().forEach(s -> imageService.saveImageToBrand(product, new AddNewImageRequest("", s.getName(), s.getUrl())));
        return ResponseEntity.ok(new AbstractResponse(product));
    }

    @Override
    public ResponseEntity<Object> updateProduct(UpdateProductRequest request) {
        Product productUpdate = findProductById(request.getId());
        if (StringHelper.isNotEmpty(request.getColor())) {
            productUpdate.setColor(request.getColor());
        }

        if(StringHelper.isNotEmpty(request.getSize())) {
            productUpdate.setSize(request.getSize());
        }

        if (StringHelper.isEmpty(request.getName())) {
            productUpdate.setName(request.getName());
        }
        if (StringHelper.isEmpty(request.getDescription())) {
            productUpdate.setDescription(request.getDescription());
        }
        if (request.getQuantity() >= 0) {
            productUpdate.setQuantity(request.getQuantity());
        }
        if (StringHelper.isNotEmpty(request.getPrice())) {
            productUpdate.setPrice(new BigDecimal(request.getPrice()));
        }
        if (request.getPriceSold() != null) {
            productUpdate.setPriceSold(new BigDecimal(request.getPriceSold()));
        }
        productRepository.save(productUpdate);
        return ResponseEntity.ok(new MessageResponse("Update successfully"));
    }

    @Override
    public ResponseEntity<Object> deleteProduct(String idDelete) {
        productRepository.deleteById(idDelete);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public ResponseEntity<Object> removeListProduct(List<String> idsList) {
        productRepository.deleteAllById(idsList);
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
    }

    @Override
    public ResponseEntity<Object> getProduct(String id) {
        return ResponseEntity.ok(new AbstractResponse(findProductById(id)));
    }

    @Override
    public ResponseEntity<Object> getListProductByCategory(String categoryId) {
        List<Product> list = productRepository.getListByCategory(categoryId);
        return ResponseEntity.ok(new AbstractResponse(list));
    }

    @Override
    public ResponseEntity<Object> getListProductByBrand(String brandId) {
        List<Product> list = productRepository.getListByBrandId(brandId);
        return ResponseEntity.ok(new AbstractResponse(list));
    }

    public Product findProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find product " + id));
    }
}
