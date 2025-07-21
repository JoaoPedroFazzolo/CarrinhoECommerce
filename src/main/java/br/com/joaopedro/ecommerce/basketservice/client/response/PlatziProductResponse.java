package br.com.joaopedro.ecommerce.basketservice.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlatziProductResponse(Long id, String title, BigDecimal price) implements Serializable {
}
