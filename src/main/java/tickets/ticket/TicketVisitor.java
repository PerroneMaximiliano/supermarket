package tickets.ticket;

public interface TicketVisitor {

    void visit(Header header);

    void visit(SaleLine saleLine);

    void visit(ReturnLine returnLine);

    void visit(RepetitionLine repetitionLine);

    void visit(CancellationLine cancellationLine);

    void visit(Footer footer);
}
