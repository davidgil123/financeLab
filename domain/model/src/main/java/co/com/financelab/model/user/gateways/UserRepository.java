package co.com.financelab.model.user.gateways;

import co.com.financelab.model.user.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserRepository {
    Mono<List<User>> getAllUser(String finnanceLab);
    Mono<User> createUser(String financelab, User user);
    Mono<User> updateUser(String financelab, String userId);
    Mono<Boolean> deleteUser(String financelab, String userId);


}
