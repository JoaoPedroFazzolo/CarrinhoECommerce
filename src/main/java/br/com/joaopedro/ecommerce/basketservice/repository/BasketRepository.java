package br.com.joaopedro.ecommerce.basketservice.repository;

import br.com.joaopedro.ecommerce.basketservice.entity.Basket;
import br.com.joaopedro.ecommerce.basketservice.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {
    Optional<Basket> findByClientAndStatus(Long client, Status status);
}
