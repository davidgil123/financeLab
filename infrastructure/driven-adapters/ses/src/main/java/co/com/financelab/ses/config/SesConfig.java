package co.com.financelab.ses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesAsyncClient;

@Configuration
public class SesConfig {
    @Bean
    public SesAsyncClient getAsyncClient(){
        return SesAsyncClient.builder().region(Region.of("us-east-1")).build();
    }
}
