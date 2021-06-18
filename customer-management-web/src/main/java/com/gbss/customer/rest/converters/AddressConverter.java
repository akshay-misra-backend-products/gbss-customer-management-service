package com.gbss.customer.rest.converters;

import com.gbss.customer.api.model.Address;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AddressConverter implements Function<com.gbss.customer.rest.json.request.Address,
        Address> {

    @Override
    public Address apply(com.gbss.customer.rest.json.request.Address source) {
        return Address.builder()
                .id(source.getId())
                .street1(source.getStreet1())
                .street2(source.getStreet2())
                .city(source.getCity())
                .stateOrProvince(source.getStateOrProvince())
                .postCode(source.getPostCode())
                .country(source.getCountry())
                .phoneNumber(source.getPhoneNumber())
                .addressType(source.getAddressType())
                .build();
    }
}
