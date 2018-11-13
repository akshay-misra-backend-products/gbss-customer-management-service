package com.bss.product.catalog.controllers;

import com.bss.product.catalog.impl.products.ProductManagementServiceImpl;
import com.bss.product.catalog.model.entities.Product;
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
 * Created by Rocky on 09-08-2018.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    ProductManagementServiceImpl productManagementService;

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
}
