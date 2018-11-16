package com.bss.product.catalog.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Rocky on 16-11-2018.
 */
@Document(collection="productCategories")
public class ProductCategory {

    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String name;

    @Size(max=1000)
    private String description;

    @DBRef
    private Set<Product> products;

    private Integer displayOrder;

    private boolean disabled;
}
