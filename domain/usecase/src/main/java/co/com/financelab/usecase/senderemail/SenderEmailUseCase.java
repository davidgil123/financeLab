package co.com.financelab.usecase.senderemail;

import co.com.financelab.model.email.FinanceLabEmail;
import co.com.financelab.model.email.gateway.EmailGateways;
import co.com.financelab.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SenderEmailUseCase {
    private final EmailGateways emailGateways;
    private final UserRepository userRepository;
    public Mono<Boolean> sendEmail(FinanceLabEmail financeLabEmail){
        return userRepository.getUserById(financeLabEmail.getFinanceLabId(),financeLabEmail.getUserId())
                .flatMap(user -> emailGateways.sendEmail(user.getEmail(),financeLabEmail.getFile()));

    }
}
