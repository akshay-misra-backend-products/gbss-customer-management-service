package com.gbss.customer.impl.repositories;

import com.gbss.customer.api.model.BillingAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingAccountRepository extends MongoRepository<BillingAccount, String> {

    List<BillingAccount> findAllByCustomerId(String customerId);
}
