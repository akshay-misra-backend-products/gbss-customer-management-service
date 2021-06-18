package com.gbss.customer.rest.json.request;

import com.gbss.common.api.model.Characteristic;
import com.gbss.customer.api.model.contants.PaymentMethodType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaymentMethod {

    private PaymentMethodType paymentMethodType;

    private boolean defaultMethod;

    private List<Characteristic> characteristic;
}
