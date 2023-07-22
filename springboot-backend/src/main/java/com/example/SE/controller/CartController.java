package com.example.SE.controller;

import com.example.SE.Collection.Cart;
import com.example.SE.Collection.Cart;
import com.example.SE.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartServiceImpl cartService;

    @Autowired
    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.saveCart(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    @GetMapping("/cartId/{cartId}")
    public ResponseEntity<List<Cart>> getCartByCartId(@PathVariable String cartId) {
        List<Cart> carts = cartService.findByCartId(cartId);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/userId/{userId}/{isActive}")
    public ResponseEntity<List<Cart>> getActiveCartByUserId(@PathVariable String userId, @PathVariable boolean isActive) {
        List<Cart> carts = cartService.findActiveCartByUserId(userId, isActive);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }
}
