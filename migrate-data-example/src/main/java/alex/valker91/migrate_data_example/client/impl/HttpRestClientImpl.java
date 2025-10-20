package alex.valker91.migrate_data_example.client.impl;

import alex.valker91.migrate_data_example.client.HttpRestClient;
import alex.valker91.migrate_data_example.client.model.EventResponse;
import org.springframework.web.client.RestClient;

public class HttpRestClientImpl implements HttpRestClient {

    private final RestClient restClient;

    public HttpRestClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public void getEventById(long id) {
        System.out.println("test "+id);
        EventResponse event = this.restClient.get().uri("/api/v1/events/" + id).retrieve().body(EventResponse.class);
        System.out.println("test "+event.title());
    }
}
