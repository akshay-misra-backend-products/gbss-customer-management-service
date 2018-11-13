package com.bss.product.catalog.api.products;

import com.bss.product.catalog.model.entities.Product;

import java.util.List;

/**
 * Created by akmi0814 on 11/13/2018.
 */
public interface ProductManagementService {

    List<Product> getAllProducts();

    Product getProductById(String id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    boolean deleteProduct(String id);

    Product activateProduct(String id);
}
