package com.gbss.customer.rest.converters;

import com.gbss.customer.api.model.PaymentMethod;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PaymentMethodConverter implements Function<com.gbss.customer.rest.json.request.PaymentMethod,
        PaymentMethod> {

    @Override
    public PaymentMethod apply(com.gbss.customer.rest.json.request.PaymentMethod source) {
        return PaymentMethod.builder()
                .name("Payment Method - " + source.getPaymentMethodType())
                .paymentMethodType(source.getPaymentMethodType())
                .defaultMethod(source.isDefaultMethod())
                .characteristic(source.getCharacteristic())
                .build();
    }
}
