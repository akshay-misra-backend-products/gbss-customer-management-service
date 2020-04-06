package com.bss.product.catalog.model.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Akshay Misra on 16-11-2018.
 */
@Document(collection="productCategories")
public class ProductCategory extends CatalogEntity {

    private boolean disabled;

    private String imageUrl;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
