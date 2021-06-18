package com.gbss.customer.impl.validator;

import com.gbss.common.api.exceptions.IncorrectRequestException;
import com.gbss.common.api.exceptions.ResourceNotFoundException;
import com.gbss.common.api.validator.PreValidator;
import com.gbss.customer.api.model.Customer;
import com.gbss.customer.api.service.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomerExistValidation<T extends Customer> implements PreValidator<T> {

    @Autowired
    private CustomerManagementService customerManagementService;

    @Override
    public List<String> getActions() {
        return Arrays.asList("UPDATE");
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void validate(final Customer customer) {
        if (customer.getId() == null) {
            throw new IncorrectRequestException("Incorrect request, 'customerId'" +
                    "is missing.");
        }
        boolean exists = this.customerManagementService.exists(customer.getId());
        if (!exists) {
            throw new ResourceNotFoundException("Customer with id '" +  customer.getId() + "' not found.");
        }
    }
}