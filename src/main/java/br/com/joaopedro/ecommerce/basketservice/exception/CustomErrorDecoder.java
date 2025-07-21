package br.com.joaopedro.ecommerce.basketservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new DataNotFoundException("product not found");
            default:
                return new Exception("Exception while getting response");
        }
    }
}
