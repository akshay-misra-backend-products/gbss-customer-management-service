package com.bss.product.catalog.impl.products;

import com.bss.product.catalog.api.products.ProductManagementService;
import com.bss.product.catalog.model.entities.Product;
import com.bss.product.catalog.model.entities.ProductCategory;
import com.bss.product.catalog.repositories.ProductCategoryRepository;
import com.bss.product.catalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Akshay Misra on 11/13/2018.
 */
@Service
public class ProductManagementServiceImpl implements ProductManagementService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        System.out.println("ProductManagementServiceImpl getAllProducts.");
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return productRepository.findAll(sortByCreatedAtDesc);
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product != null){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product activateProduct(String id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setActive(true);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public List<ProductCategory> getAllCategories() {
        System.out.println("ProductManagementServiceImpl getAllCategories.");
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return categoryRepository.findAll(sortByCreatedAtDesc);
    }

    @Override
    public ProductCategory getProductCategoryById(String id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteProductCategory(String id) {
        Optional<ProductCategory> product = categoryRepository.findById(id);
        if(product != null){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
