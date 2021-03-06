package com.gbss.customer.impl.repositories;

import com.gbss.customer.api.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

    List<Address> findAllByCustomerId(String customerId);
}
