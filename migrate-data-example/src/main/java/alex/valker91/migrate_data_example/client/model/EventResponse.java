package alex.valker91.migrate_data_example.client.model;

import java.util.Date;

public record EventResponse(
        long id,
        String title,
        String date,
        int ticketPrice
) {
    @Override
    public long id() {
        return id;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String date() {
        return date;
    }

    @Override
    public int ticketPrice() {
        return ticketPrice;
    }
}
