package com.gbss.customer.impl.validator;

import com.gbss.common.api.exceptions.ResourceNotFoundException;
import com.gbss.common.api.validator.PostValidator;
import com.gbss.customer.api.model.Customer;
import com.gbss.customer.impl.repositories.BillingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

@Component
public class BillingAccountPostValidator<T extends Customer> implements PostValidator<T> {

    private final BillingAccountValidator billingAccountValidator;

    private final BillingAccountRepository billingAccountRepository;

    @Autowired
    public BillingAccountPostValidator(BillingAccountValidator billingAccountValidator,
                                       BillingAccountRepository billingAccountRepository) {
        this.billingAccountValidator = billingAccountValidator;
        this.billingAccountRepository = billingAccountRepository;
    }

    @Override
    public List<String> getActions() {
        return Arrays.asList("UPDATE");
    }

    @Override
    public int getOrder() {
        return 5;
    }

    @Override
    public void validate(Customer customer) {
        this.billingAccountValidator.validate(customer);
        if (!CollectionUtils.isEmpty(customer.getBillingAccount())) {
            customer.getBillingAccount()
                    .stream()
                    .filter(billingAccount -> billingAccount.getId() != null)
                    .forEach(billingAccount -> {
                        final boolean exist = this.billingAccountRepository.existsById(billingAccount.getId());
                        if (!exist) {
                            throw new ResourceNotFoundException("'billingAccount' with id '" +
                                    billingAccount.getId() + "' not found.");
                        }
                    });
        }
    }
}
