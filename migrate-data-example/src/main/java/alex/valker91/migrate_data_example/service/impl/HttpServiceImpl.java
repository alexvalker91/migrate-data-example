package alex.valker91.migrate_data_example.service.impl;

import alex.valker91.migrate_data_example.client.HttpRestClient;
import alex.valker91.migrate_data_example.client.impl.HttpRestClientImpl;
import alex.valker91.migrate_data_example.service.HttpService;
import org.springframework.stereotype.Service;

@Service
public class HttpServiceImpl implements HttpService {

    private final HttpRestClient httpRestClient;

    public HttpServiceImpl(HttpRestClient httpRestClient) {
        this.httpRestClient = httpRestClient;
    }

    @Override
    public void getData(long id) {
        httpRestClient.getEventById(id);
    }
}
