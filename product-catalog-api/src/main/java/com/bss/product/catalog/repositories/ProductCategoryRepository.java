package com.bss.product.catalog.repositories;

import com.bss.product.catalog.model.entities.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Akshay Misra on 06-04-2020.
 */
@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
