package co.com.financelab.api.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;
@UtilityClass
public class RequestUtil {
    public Mono<String> buildGetAllUser(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("finance-lab"));
    }
}
