package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.response.MessageResponse;
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
        return ResponseEntity.ok(new MessageResponse("Add new product successfully"));
    }

    @Override
    public ResponseEntity<Object> removeProductToCart(HttpServletRequest request, String productId) {
        Cart cart = getCartByServletRequest(request);
        Product product = productService.findProductById(productId);
        List<Product> products =  cart.getProductListCart();
        products.remove(product);
        productService.addCartToProduct(cart, productId);
        cartRepository.save(cart);
        return ResponseEntity.ok(new MessageResponse("Remove new product successfully"));
    }

    @Override
    public ResponseEntity<Object> removeListProductCart(HttpServletRequest request, List<String> productId) {
        Cart cart = getCartByServletRequest(request);
        List<Product> cartProductList = cart.getProductListCart();
        productId.forEach(
                s -> {
                    cartProductList.stream()
                            .filter(product -> product.getId().equalsIgnoreCase(s))
                            .findFirst().ifPresent(deleteProduct -> productService.deleteProduct(s));
                }
        );
        return ResponseEntity.ok(new MessageResponse("Delete successfully"));
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
