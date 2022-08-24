package tickets.ticket;

public abstract class Line {

    private Double price;

    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }

    public abstract void accept(TicketVisitor ticketVisitor);
}
