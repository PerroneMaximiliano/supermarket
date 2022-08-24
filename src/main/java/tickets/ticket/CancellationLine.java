package tickets.ticket;

public class CancellationLine extends NumberLine {

    public CancellationLine(int number) {
        super(number);
    }

    @Override
    public void accept(TicketVisitor ticketVisitor) {
        ticketVisitor.visit(this);
    }
}
