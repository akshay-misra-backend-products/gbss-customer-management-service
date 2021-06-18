package com.gbss.customer.rest.json.request;

import com.gbss.common.api.model.Characteristic;
import com.gbss.customer.api.model.contants.CustomerCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Customer {

    private String id;

    private String firstName;

    private String lastName;

    private String primaryEmail;

    private String secondaryEmail;

    private CustomerCategory customerCategory;

    private List<ContactMedium> contactMedium;

    private List<Address> address;

    private List<Characteristic> characteristic;

    private List<BillingAccount> billingAccount;
}
