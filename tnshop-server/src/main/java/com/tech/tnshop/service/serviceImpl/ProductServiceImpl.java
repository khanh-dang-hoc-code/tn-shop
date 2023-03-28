package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.mapper.ProductMapper;
import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.dto.request.product.UpdateProductRequest;
import com.tech.tnshop.entity.Brand;
import com.tech.tnshop.entity.Cart;
import com.tech.tnshop.entity.Category;
import com.tech.tnshop.entity.Product;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.repository.IProductRepository;
import com.tech.tnshop.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;

    private final BrandServiceImpl brandService;
    private final CategoryServiceImpl categoryService;


    @Override
    public ResponseEntity<Object> getAllProducts(int index, int limit) {
        Pageable pageable = PageRequest.of(0, 20);
        Page<Product> products = productRepository.findAll(pageable);
        return ResponseEntity.ok(products.getContent());
    }

    @Override
    public ResponseEntity<Object> addNewProduct(AddNewProductRequest request) {
        Product product = ProductMapper.mapToProduct(request);
        Brand brand = brandService.findBrandById(request.getBrandId());
        Category category = categoryService.findCategoryById(request.getCategoryId());
        product.setBrand(brand);
        product.setCategory(category);
        productRepository.save(product);
        return ResponseEntity.ok("Add new product successfully");
    }

    @Override
    public ResponseEntity<Object> updateProduct(UpdateProductRequest request) {
        Product productUpdate = findProductById(request.getId());
        if (StringHelper.isEmpty(request.getName())) {
            productUpdate.setName(request.getName());
        }
        if (StringHelper.isEmpty(request.getDescription())) {
            productUpdate.setDescription(request.getDescription());
        }
        if (request.getQuantity() >= 0) {
            productUpdate.setQuantity(request.getQuantity());
        }
        if (request.getPriceSold() != null) {
            productUpdate.setPriceSold(request.getPriceSold());
        }
        productRepository.save(productUpdate);
        return ResponseEntity.ok("Update successfully");
    }

    @Override
    public ResponseEntity<Object> deleteProduct(String idDelete) {
        Product productDelete = findProductById(idDelete);
        productRepository.delete(productDelete);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public ResponseEntity<Object> removeListProduct(List<String> idsList) {
            idsList.forEach(id -> {
                Product productDelete = findProductById(id);
                productRepository.delete(productDelete);
            });
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public ResponseEntity<Object> getProduct(String id) {
        return ResponseEntity.ok(findProductById(id));
    }

    @Override
    public void addCartToProduct(Cart cart, String productId) {
        Product product = findProductById(productId);
        List<Cart> carts = product.getCarts();
        carts.add(cart);
        product.setCarts(carts);
        productRepository.save(product);
    }

    @Override
    public void removeCartToProduct(Cart cart, String productId) {
        Product product = findProductById(productId);
        List<Cart> carts = product.getCarts();
        carts.remove(cart);
        product.setCarts(carts);
        productRepository.save(product);
    }

    public Product findProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find product " + id));
    }
}
