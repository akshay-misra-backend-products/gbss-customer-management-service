package com.bss.product.catalog.impl.products;

import com.bss.product.catalog.api.products.ProductManagementService;
import com.bss.product.catalog.model.entities.Product;
import com.bss.product.catalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by akmi0814 on 11/13/2018.
 */
@Service
public class ProductManagementServiceImpl implements ProductManagementService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        System.out.println("ProductManagementServiceImpl getAllProducts.");
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return repository.findAll(sortByCreatedAtDesc);
    }

    @Override
    public Product getProductById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public boolean deleteProduct(String id) {
        Optional<Product> product = repository.findById(id);
        if(product != null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product activateProduct(String id) {
        Optional<Product> productOpt = repository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setActive(true);
            return repository.save(product);
        }
        return null;
    }
}
