package br.com.joaopedro.ecommerce.basketservice.controller.request;

import lombok.Builder;


public record ProductRequest(Long id, Integer quantity) {
}
