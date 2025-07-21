package br.com.joaopedro.ecommerce.basketservice.service;

import br.com.joaopedro.ecommerce.basketservice.client.response.PlatziProductResponse;
import br.com.joaopedro.ecommerce.basketservice.controller.request.BasketRequest;
import br.com.joaopedro.ecommerce.basketservice.entity.Basket;
import br.com.joaopedro.ecommerce.basketservice.entity.Product;
import br.com.joaopedro.ecommerce.basketservice.entity.Status;
import br.com.joaopedro.ecommerce.basketservice.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Basket getBasketById(String id) {
        return basketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Basket not found"));
    }

    public Basket createBasket(BasketRequest basketRequest) {

        basketRepository.findByClientAndStatus(basketRequest.clientId(), Status.OPEN)
                .ifPresent(basket -> {
                    throw new IllegalArgumentException("Already exists basket open for this client");
                });

        List<Product> products = new ArrayList<>();
        basketRequest.products().forEach(product -> {
            PlatziProductResponse platziProductResponse = productService.getProductById(product.id());
            products.add(Product.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(product.quantity())
                    .build());

        });

        Basket basket = Basket.builder()
                .client(basketRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();
        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }


}
