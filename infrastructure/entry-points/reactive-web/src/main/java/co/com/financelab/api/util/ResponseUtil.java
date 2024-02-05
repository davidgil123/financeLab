package co.com.financelab.api.util;

import co.com.financelab.model.income.Income;
import co.com.financelab.model.user.User;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@UtilityClass

public class ResponseUtil {
    public Mono<ServerResponse> buildResponseAllUser(List<User> userList){
        return ServerResponse.ok().bodyValue(userList);
    }
    public Mono<ServerResponse> buildResponseCreateUser(User user){
        user.setPassword("*****");
        return ServerResponse.status(201).bodyValue(user);
    }
    public Mono<ServerResponse> buildResponseUpdateUser(User user){
        user.setPassword("*****");
        return ServerResponse.ok().bodyValue(user);
    }
    public Mono<ServerResponse> buildResponseDeleteUser(Boolean result){
        return ServerResponse.ok().bodyValue(result);
    }
    public Mono<ServerResponse> buildResponseAllIncome(List<Income> incomeList){
        return ServerResponse.ok().bodyValue(incomeList);
    }
}
