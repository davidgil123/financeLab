package co.com.financelab.model.email.gateway;

import reactor.core.publisher.Mono;

public interface EmailGateways {
    Mono<Boolean> sendEmail(String emailAddress, byte[] file);
}
