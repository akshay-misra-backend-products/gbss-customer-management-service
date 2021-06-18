package com.gbss.common.api.validator.factory;

import com.gbss.common.api.validator.Validator;

import java.util.List;

public interface ValidatorFactory {

    List<Validator> getPreValidators(String action);

    List<Validator> getPostValidators(String action);
}
