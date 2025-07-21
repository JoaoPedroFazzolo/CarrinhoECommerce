package br.com.joaopedro.ecommerce.basketservice.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Product {

    private Long id;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
