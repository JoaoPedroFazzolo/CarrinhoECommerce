package br.com.joaopedro.ecommerce.basketservice.controller;

import br.com.joaopedro.ecommerce.basketservice.controller.request.BasketRequest;
import br.com.joaopedro.ecommerce.basketservice.entity.Basket;
import br.com.joaopedro.ecommerce.basketservice.repository.BasketRepository;
import br.com.joaopedro.ecommerce.basketservice.service.BasketService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final BasketRepository basketRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable("id") String id) {
        return ResponseEntity.ok(basketService.getBasketById(id));
    }

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.createBasket(request));
    }
}
