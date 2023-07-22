package com.example.SE.repository;

import com.example.SE.Collection.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    @Override
    Cart save(Cart cart);
    List<Cart> findByCartId(String cartId);

    @Query("{'userId': ?0, 'isActive': ?1}")
    List<Cart> findActiveCartByUserId(String userId, boolean isActive);
}
