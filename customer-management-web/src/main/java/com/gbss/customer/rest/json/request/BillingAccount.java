package com.gbss.customer.rest.json.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class BillingAccount {

    private String id;

    private Boolean defaultBillingAccount;

    private String currency;

    private List<PaymentMethod> paymentMethod;
}
