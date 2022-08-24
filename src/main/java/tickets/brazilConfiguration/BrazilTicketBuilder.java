package tickets.brazilConfiguration;

import tickets.countryConfiguration.TicketBuilder;
import tickets.operations.PriceCalculatorOperation;
import tickets.operations.TaxPrinterOperation;
import tickets.operations.TicketOperationComposite;
import tickets.ticket.Footer;
import tickets.ticket.Header;
import tickets.ticket.Ticket;

public class BrazilTicketBuilder extends TicketBuilder {

    public BrazilTicketBuilder() {
        lineTicketOperation = new PriceCalculatorOperation();
        TicketOperationComposite globalTicketOperationComposite = new TicketOperationComposite();
        globalTicketOperationComposite.add(new PriceCalculatorOperation());
        globalTicketOperationComposite.add(new TaxPrinterOperation());
        globalTicketOperation = globalTicketOperationComposite;
    }

    @Override
    public Ticket build() {
        Ticket ticket = new Ticket(new Header(), new Footer());
        ticket.setLineTicketOperation(lineTicketOperation);
        ticket.setGlobalTicketOperation(lineTicketOperation);
        lineTicketOperation.set(ticket);
        globalTicketOperation.set(ticket);
        return ticket;
    }
}
