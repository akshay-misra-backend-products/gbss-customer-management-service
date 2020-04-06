package com.bss.product.catalog.controllers;

import com.bss.product.catalog.api.products.ProductManagementService;
import com.bss.product.catalog.model.entities.Product;
import com.bss.product.catalog.model.entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Akshay Misra on 09-08-2018.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    ProductManagementService productManagementService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productManagementService.getAllProducts();
    }

    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product product) {
        return productManagementService.createProduct(product);
    }

    @GetMapping(value="/product/{id}")
    public Product getProductById(@PathVariable("id") String id) {
        return productManagementService.getProductById(id);
    }

    @PutMapping(value="/update")
    public Product updateProduct(@Valid @RequestBody Product product) {
        return productManagementService.updateProduct(product);
    }

    @DeleteMapping(value="/delete/{id}")
    public boolean deleteProduct(@PathVariable("id") String id) {
        return productManagementService.deleteProduct(id);
    }

    @GetMapping("/all/product-categories")
    public List<ProductCategory> getAllCategories() {
        return productManagementService.getAllCategories();
    }

    @PostMapping("/add/product-category")
    public ProductCategory addCategory(@Valid @RequestBody ProductCategory category) {
        return productManagementService.createProductCategory(category);
    }

    @GetMapping(value="/get/product-category/{id}")
    public ProductCategory getCategoryById(@PathVariable("id") String id) {
        return productManagementService.getProductCategoryById(id);
    }

    @PutMapping(value="/update/product-category")
    public ProductCategory updateCategory(@Valid @RequestBody ProductCategory category) {
        return productManagementService.updateProductCategory(category);
    }

    @DeleteMapping(value="/delete/product-category/{id}")
    public boolean deleteCategory(@PathVariable("id") String id) {
        return productManagementService.deleteProductCategory(id);
    }
}
