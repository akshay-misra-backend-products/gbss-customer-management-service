package com.gbss.customer.api.model;

import com.gbss.common.api.model.Characteristic;
import com.gbss.common.api.model.HasHrefName;
import com.gbss.customer.api.model.contants.CustomerCategory;
import com.gbss.customer.api.model.contants.CustomerStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@Document(collection="customers")
public class Customer extends HasHrefName {

    private String firstName;

    private String lastName;

    @Indexed(name = "primary_email_index")
    private String primaryEmail;

    private String secondaryEmail;

    @Indexed(name = "account_number_index")
    private String accountNumber;

    private CustomerCategory customerCategory;

    private CustomerStatus status;

    private String statusReason;

    private List<Characteristic> characteristic;

    @Indexed(name = "contact_medium_index")
    private List<ContactMedium> contactMedium;

    private List<Address> address;

    private List<BillingAccount> billingAccount;
}
