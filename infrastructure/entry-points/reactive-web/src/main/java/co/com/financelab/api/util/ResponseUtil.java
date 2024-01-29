package co.com.financelab.api.util;

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
}
