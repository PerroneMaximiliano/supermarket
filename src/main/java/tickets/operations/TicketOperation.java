package tickets.operations;

import tickets.ticket.*;

public class TicketOperation implements TicketVisitor {

    protected Ticket ticket;

    public void set(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void visit(Header header) {

    }

    @Override
    public void visit(SaleLine saleLine) {

    }

    @Override
    public void visit(ReturnLine returnLine) {

    }

    @Override
    public void visit(RepetitionLine repetitionLine) {

    }

    @Override
    public void visit(CancellationLine cancellationLine) {

    }

    @Override
    public void visit(Footer footer) {

    }
}
