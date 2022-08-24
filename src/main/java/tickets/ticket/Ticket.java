package tickets.ticket;

import tickets.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private Header header;
    private List<Line> lineList;

    private Footer footer;

    private TicketVisitor lineTicketOperation;

    private TicketVisitor globalTicketOperation;

    public Ticket(Header header, Footer footer) {
        this.header = header;
        this.lineList = new ArrayList<>();
        this.footer = footer;
    }

    public void setLineTicketOperation(TicketVisitor lineTicketOperation) {
        this.lineTicketOperation = lineTicketOperation;
    }

    public void setGlobalTicketOperation(TicketVisitor globalTicketOperation) {
        this.globalTicketOperation = globalTicketOperation;
    }

    public int lines() {
        return lineList.size();
    }

    public void open() {
        header.accept(lineTicketOperation);
    }

    public void add(Line line) {
        lineList.add(line);
        line.accept(lineTicketOperation);
    }

    public void close() {
        footer.accept(lineTicketOperation);
        header.accept(globalTicketOperation);
        lineList.forEach(line -> line.accept(globalTicketOperation));
        footer.accept(globalTicketOperation);
    }

    public void write() {
        lineList.forEach(item -> Console.instance().writeln(item.toString()));
    }

    public Line getLine(int number) {
        return lineList.get(number);
    }
}
