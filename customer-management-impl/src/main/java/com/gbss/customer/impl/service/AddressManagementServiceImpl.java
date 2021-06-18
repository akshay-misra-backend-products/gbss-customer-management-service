package com.gbss.customer.impl.service;

import com.gbss.common.api.exceptions.ResourceNotFoundException;
import com.gbss.customer.api.model.Address;
import com.gbss.customer.api.service.AddressManagementService;
import com.gbss.customer.impl.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressManagementServiceImpl implements AddressManagementService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAddress() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getAddressById(String id) {
        return this.addressRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Address with id '" +  id + "' not found."));
    }

    @Override
    public Address createAddress(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return this.addressRepository.save(address);
    }
}
