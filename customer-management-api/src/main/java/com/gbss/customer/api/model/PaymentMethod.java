package com.gbss.customer.api.model;

import com.gbss.common.api.model.Characteristic;
import com.gbss.common.api.model.HasHrefName;
import com.gbss.customer.api.model.contants.PaymentMethodType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;

@Data
@SuperBuilder
@NoArgsConstructor
public class PaymentMethod extends HasHrefName {

    private PaymentMethodType paymentMethodType;

    private boolean defaultMethod;

    private List<Characteristic> characteristic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod)) return false;
        PaymentMethod that = (PaymentMethod) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
