package com.bss.product.catalog.model.entities;

import com.bss.framework.core.schema.model.Base;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by Akshay Misra on 16-11-2018.
 */
@Document(collection="tags")
public class Tags extends Base {
}
