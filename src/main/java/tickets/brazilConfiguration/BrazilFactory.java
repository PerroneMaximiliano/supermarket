package tickets.brazilConfiguration;

import tickets.countryConfiguration.CountryFactory;
import tickets.menu.Menu;
import tickets.ticket.Ticket;

public class BrazilFactory extends CountryFactory {

    @Override
    public Menu getMenu() {
        return new BrazilMenu();
    }

    @Override
    public Ticket getTicket() {
        return new BrazilTicketBuilder().build();
    }
}
