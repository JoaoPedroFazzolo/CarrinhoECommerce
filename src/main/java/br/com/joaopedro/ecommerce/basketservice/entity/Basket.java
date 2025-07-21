package br.com.joaopedro.ecommerce.basketservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "basket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Basket {

    @Id
    private String id;

    private Long client;

    private BigDecimal totalPrice;

    private List<Product> products;

    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaymentMethod paymentMethod;

    public void calculateTotalPrice() {
        this.totalPrice = products.stream().map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
