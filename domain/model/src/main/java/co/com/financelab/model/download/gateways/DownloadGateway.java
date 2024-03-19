package co.com.financelab.model.download.gateways;

import reactor.core.publisher.Mono;

import java.util.List;

public interface DownloadGateway {
    Mono<byte[]> generateFile(UserWithAllData userWithAllData);
}
