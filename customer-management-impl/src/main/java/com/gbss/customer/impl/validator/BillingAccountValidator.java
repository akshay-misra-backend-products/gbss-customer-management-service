package com.gbss.customer.impl.validator;

import com.gbss.common.api.exceptions.IncorrectRequestException;
import com.gbss.common.api.validator.PreValidator;
import com.gbss.customer.api.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

@Component
public class BillingAccountValidator<T extends Customer> implements PreValidator<T> {

    @Override
    public List<String> getActions() {
        return Arrays.asList("CREATE");
    }

    @Override
    public int getOrder() {
        return 5;
    }

    @Override
    public void validate(final Customer customer) {
        if (!CollectionUtils.isEmpty(customer.getBillingAccount())) {
            long defaultBillingAccounts = customer.getBillingAccount().stream()
                    .filter(billingAccount -> Boolean.TRUE.equals(billingAccount.getDefaultBillingAccount()))
                    .count();

            if (defaultBillingAccounts > 1L) {
                throw new IncorrectRequestException("Incorrect request, maximum one 'billingAccount' can be " +
                        "marked as 'default'.");
            }

            customer.getBillingAccount()
                    .stream()
                    .forEach(billingAccount -> {
                        if (billingAccount.getCurrency() == null) {
                            throw new IncorrectRequestException("Incorrect request, 'currency' is required " +
                                    "in 'billingAccount'.");
                        }
                    });
        }
    }
}