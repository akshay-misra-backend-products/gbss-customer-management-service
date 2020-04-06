package com.bss.product.catalog.api.products;

import com.bss.product.catalog.model.entities.Product;
import com.bss.product.catalog.model.entities.ProductCategory;

import java.util.List;

/**
 * Created by Akshay Misra on 11/13/2018.
 */
public interface ProductManagementService {

    List<Product> getAllProducts();

    Product getProductById(String id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    boolean deleteProduct(String id);

    Product activateProduct(String id);

    List<ProductCategory> getAllCategories();

    ProductCategory getProductCategoryById(String id);

    ProductCategory createProductCategory(ProductCategory category);

    ProductCategory updateProductCategory(ProductCategory category);

    boolean deleteProductCategory(String id);
}
