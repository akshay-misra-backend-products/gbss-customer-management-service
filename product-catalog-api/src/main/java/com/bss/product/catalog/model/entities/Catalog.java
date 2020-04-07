package com.bss.product.catalog.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Akshay Misra on 06-04-2020.
 */
@Document(collection="catalogs")
public class Catalog {

    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    private String name;

    @Size(max=1000)
    private String description;

    private Locale defaultLocale;

    private Currency defaultCurrency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
}
