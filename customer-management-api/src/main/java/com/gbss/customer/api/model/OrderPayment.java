package com.gbss.customer.api.model;

import com.gbss.common.api.model.Characteristic;
import com.gbss.common.api.model.HasHrefName;
import com.gbss.customer.api.model.contants.OrderPaymentStatus;
import com.gbss.customer.api.model.contants.PaymentMethodType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class OrderPayment extends HasHrefName {

  private OrderPaymentStatus status;

  private Double amount;

  private PaymentMethodType type;

  private List<Characteristic> characteristic;
}
