package alex.valker91.migrate_data_example.config;

import alex.valker91.migrate_data_example.client.HttpRestClient;
import alex.valker91.migrate_data_example.client.impl.HttpRestClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public HttpRestClientImpl httpRestClient() {
        return new HttpRestClientImpl(RestClient.builder().baseUrl("http://localhost:8083").build());
    }
}
