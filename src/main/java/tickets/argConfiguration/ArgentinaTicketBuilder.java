package tickets.argConfiguration;

import tickets.countryConfiguration.TicketBuilder;
import tickets.operations.PriceCalculatorOperation;
import tickets.operations.PrinterOperation;
import tickets.operations.TaxPrinterOperation;
import tickets.operations.TicketOperationComposite;
import tickets.ticket.Footer;
import tickets.ticket.Header;
import tickets.ticket.Ticket;

public class ArgentinaTicketBuilder extends TicketBuilder {

    public ArgentinaTicketBuilder() {
        TicketOperationComposite lineTicketOperationComposite = new TicketOperationComposite();
        lineTicketOperationComposite.add(new PriceCalculatorOperation());
        lineTicketOperationComposite.add(new PrinterOperation());
        lineTicketOperationComposite.add(new TaxPrinterOperation());
        lineTicketOperation = lineTicketOperationComposite;
        TicketOperationComposite globalTicketOperationComposite = new TicketOperationComposite();
        globalTicketOperationComposite.add(new PriceCalculatorOperation());
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
