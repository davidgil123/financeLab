package co.com.financelab.ses;

import co.com.financelab.model.email.gateway.EmailGateways;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.ses.SesAsyncClient;
import software.amazon.awssdk.services.ses.model.RawMessage;
import software.amazon.awssdk.services.ses.model.SendRawEmailRequest;

@Component
@RequiredArgsConstructor
public class SesAdapter implements EmailGateways {
    private final SesAsyncClient sesAsyncClient;
    private static final String SENDER="documentos@financelab.com";
    @Override
    public Mono<Boolean> sendEmail(String emailAddress, byte[] file) {
        var sendMailRawRequest= SendRawEmailRequest.builder()
                .destinations(emailAddress)
                .source(SENDER).rawMessage(RawMessage.builder().data(SdkBytes.fromByteArray(file)).build()).build();
        return Mono.fromFuture(sesAsyncClient.sendRawEmail(sendMailRawRequest))
                .thenReturn(Boolean.TRUE);
    }
}
