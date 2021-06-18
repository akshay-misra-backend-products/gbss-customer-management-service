package com.gbss.common.api.validator;

import java.util.List;

public interface Validator<T> {

    List<String> getActions();

    int getOrder();

    void validate(T entity);
}
