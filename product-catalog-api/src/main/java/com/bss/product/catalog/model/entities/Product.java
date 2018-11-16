package com.bss.product.catalog.model.entities;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Rocky on 09-08-2018.
 */

@Document(collection="products")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Product {

    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String title;

    @Size(max=1000)
    private String description;

    @DBRef
    @NotBlank
    private Set<ProductCategory> productCategories;

    @DBRef
    private Set<Tags> tags;

    @NotBlank
    private String price;

    private String imageUrl;

    private boolean active;

    private Date createdAt = new Date();

    public Product() {
    }

    public Product(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%s, title='%s', description='%s', productCategories='%s', tags='%s', price='%s', createdAt='%s']",
                id, title, description, productCategories, tags, price, createdAt);
    }
}
