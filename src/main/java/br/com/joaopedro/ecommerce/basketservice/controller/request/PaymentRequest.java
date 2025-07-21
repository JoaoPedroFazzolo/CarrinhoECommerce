package br.com.joaopedro.ecommerce.basketservice.controller.request;

import br.com.joaopedro.ecommerce.basketservice.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private PaymentMethod paymentMethod;

}
