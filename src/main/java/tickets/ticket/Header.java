package tickets.ticket;

import java.util.Date;

public class Header {
    private Date date;

    public Header() {
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void accept(TicketVisitor ticketVisitor) {
        ticketVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "Header{" + "date=" + date + '}';
    }
}
