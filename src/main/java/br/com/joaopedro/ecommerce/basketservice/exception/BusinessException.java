package br.com.joaopedro.ecommerce.basketservice.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
