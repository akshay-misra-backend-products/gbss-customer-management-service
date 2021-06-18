package com.gbss.customer.rest.converters;

import com.gbss.customer.api.model.ContactMedium;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ContactMediumConverter implements Function<com.gbss.customer.rest.json.request.ContactMedium,
        ContactMedium> {

    @Override
    public ContactMedium apply(com.gbss.customer.rest.json.request.ContactMedium source) {
        return ContactMedium.builder()
                .id(source.getId())
                .preferred(source.isPreferred())
                .type(source.getType())
                .characteristic(source.getCharacteristic())
                .build();
    }
}
