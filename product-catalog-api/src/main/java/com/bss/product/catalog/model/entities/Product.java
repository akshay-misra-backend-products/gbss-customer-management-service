package com.bss.product.catalog.model.entities;

import java.util.Collection;
import java.util.Set;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Akshay Misra on 09-08-2018.
 */
@Document(collection="products")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Product extends CatalogEntity {

    @DBRef
    @NotBlank
    private Set<ProductCategory> productCategories;

    @DBRef
    private Set<Tags> tags;

    @NotBlank
    private String price;

    private String imageUrl;

    private boolean active;

    public Product() {
    }

    public Product(String name) {
        this.setName(name);
    }

    public Set<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public void addProductCategory(ProductCategory productCategory) {
        this.productCategories.add(productCategory);
    }

    public void addProductCategories(Collection<ProductCategory> productCategories) {
        this.productCategories.addAll(productCategories);
    }

    public Set<Tags> getTags() {
        return tags;
    }

    public void setTags(Set<Tags> tags) {
        this.tags = tags;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%s, name='%s', description='%s', productCategories='%s', tags='%s', price='%s', createdAt='%s']",
                getId(), getName(), getDescription(), productCategories, tags, price, getCreatedAt());
    }
}
