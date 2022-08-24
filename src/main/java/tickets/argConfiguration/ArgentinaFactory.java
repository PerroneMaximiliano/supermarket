package tickets.argConfiguration;

import tickets.countryConfiguration.CountryFactory;
import tickets.menu.Menu;
import tickets.ticket.Ticket;

public class ArgentinaFactory extends CountryFactory {

    @Override
    public Menu getMenu() {
        return new ArgentinaMenu();
    }

    @Override
    public Ticket getTicket() {
        return new ArgentinaTicketBuilder().build();
    }
}
