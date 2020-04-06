package com.bss.product.catalog.model.entities;

import com.bss.framework.core.schema.model.Base;

/**
 * Created by Akshay Misra on 06-04-2020.
 */
public class CatalogEntity extends Base {

    private String catalogId;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
}
