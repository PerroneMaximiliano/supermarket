package tickets.supermarket;

import tickets.countryConfiguration.CountryFactory;
import tickets.menu.Menu;
import tickets.ticket.Ticket;
import tickets.utils.Clock;

public class Supermarket {
    private Menu menu;
    public Supermarket() {
        menu = CountryFactory.instance().getMenu();
    }
    private void sell() {
        Clock clock = new Clock();
        do {
            Ticket ticket = CountryFactory.instance().getTicket();
            ticket.open();
            menu.execute(ticket);
        } while(clock.isClosed());
    }

    public static void main(String[] args) {
        new Supermarket().sell();
    }
}
