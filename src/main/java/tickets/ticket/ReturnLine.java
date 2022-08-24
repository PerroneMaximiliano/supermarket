package tickets.ticket;

public class ReturnLine extends IdLine {

    public ReturnLine(int id, int units) {
        super(id, units);
    }

    @Override
    public void accept(TicketVisitor ticketVisitor) {
        ticketVisitor.visit(this);
    }
}
