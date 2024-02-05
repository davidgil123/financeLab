package co.com.financelab.api.util;

import co.com.financelab.model.user.User;
import co.com.financelab.model.user.UserDeleteRequest;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;
@UtilityClass
public class RequestUtil {
    public Mono<String> buildGetAllUser(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("finance-lab"));
    }
    public Mono<User> buidCreateUser(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(User.class);
    }
    public Mono<User> buildUpdateUser(ServerRequest serverRequest){
        return serverRequest.bodyToMono(User.class);
    }
    public Mono<UserDeleteRequest> buildDeleteUser(ServerRequest serverRequest){
        return Mono.just(UserDeleteRequest.builder().financeLabId(serverRequest.headers().firstHeader("finance-lab"))
                .userId(serverRequest.pathVariable("id")).build());
    }
    public Mono<String> buildGetAllIncomes(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("finance-lab"));
    }

    public static <T> Mono<T> buildGetAllIncome(ServerRequest serverRequest) {
        return (Mono<T>) Mono.just(serverRequest.headers().firstHeader("finance-lab"));
    }
}
