package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.cart.AddNewCartRequest;
import com.tech.tnshop.entity.Cart;
import com.tech.tnshop.entity.Product;
import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.ICartRepository;
import com.tech.tnshop.service.ICartService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final ICartRepository cartRepository;
    private final ProductServiceImpl productService;
    private final AuthenticateService authenticateService;
    @Override
    public void createNewCart(User user) {
        Cart cart = new Cart();
        cart.setCartUser(user);
        cartRepository.save(cart);
    }

    @Override
    public ResponseEntity<Object> addProductToCart(HttpServletRequest request, String productId) {
        Cart cart = getCartByServletRequest(request);
        Product product = productService.findProductById(productId);
        List<Product> products =  cart.getProductListCart();
        products.add(product);
        productService.addCartToProduct(cart, productId);
        cartRepository.save(cart);
        return ResponseEntity.ok("Add new product successfully");
    }

    @Override
    public ResponseEntity<Object> removeProductToCart(HttpServletRequest request, String productId) {
        Cart cart = getCartByServletRequest(request);
        Product product = productService.findProductById(productId);
        List<Product> products =  cart.getProductListCart();
        products.remove(product);
        productService.addCartToProduct(cart, productId);
        cartRepository.save(cart);
        return ResponseEntity.ok("Remove new product successfully");
    }

    @Override
    public ResponseEntity<Object> removeListProductCart(HttpServletRequest request, List<String> productId) {
        return null;
    }

    public Cart findCartById(String cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new NotFoundException("Can not find cart " + cartId));
    }

    private Cart getCartByServletRequest(HttpServletRequest request) {
        User user = authenticateService.getUserFromToken(request);
        return user.getCartUser();
    }
}
