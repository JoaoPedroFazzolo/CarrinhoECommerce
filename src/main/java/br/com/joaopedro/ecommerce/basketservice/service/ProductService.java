package br.com.joaopedro.ecommerce.basketservice.service;

import br.com.joaopedro.ecommerce.basketservice.client.PlatziStoreClient;
import br.com.joaopedro.ecommerce.basketservice.client.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAllProducts() {
        log.info("Get all products");
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#id")
    public PlatziProductResponse getProductById(Long id) {
        log.info("Get product by id: {}", id);
        return platziStoreClient.getProductById(id);
    }
}
