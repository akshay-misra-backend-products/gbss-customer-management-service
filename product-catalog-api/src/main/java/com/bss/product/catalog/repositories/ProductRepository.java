package com.bss.product.catalog.repositories;

import com.bss.product.catalog.model.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Akshay Misra on 09-08-2018.
 */
@Repository
public interface ProductRepository  extends MongoRepository<Product, String> {
}
