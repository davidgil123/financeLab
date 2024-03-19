package co.com.financelab.model.user.gateways;

import co.com.financelab.model.income.Income;
import co.com.financelab.model.user.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserRepository {
    Mono<List<User>> getAllUser(String finnanceLab);
    Mono<User> createUser(User user);
    Mono<User> updateUser(User user);
    Mono<Boolean> deleteUser(String financelab, String userId);
    Mono<User> getUserById(String financelab, String userId);
}
