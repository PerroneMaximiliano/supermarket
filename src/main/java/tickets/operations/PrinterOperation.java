package tickets.operations;

import tickets.ticket.*;
import tickets.utils.Console;

public class PrinterOperation extends TicketOperation {

    @Override
    public void visit(Header header) {
        Console.instance().writeln("PrinterOperation Head: " + header.getDate());
    }

    @Override
    public void visit(SaleLine saleLine) {
        Console.instance().writeln("PrinterOperation: Sale " + saleLine.getId() + " - " + saleLine.getUnits() + " units : $" + saleLine.getPrice());
    }

    @Override
    public void visit(ReturnLine returnLine) {
        Console.instance().writeln("PrinterOperation: Return " + returnLine.getId() + " - " + returnLine.getUnits() + " units : $" + returnLine.getPrice());
    }

    @Override
    public void visit(RepetitionLine repetitionLine) {
        Console.instance().writeln("PrinterOperation: Repetition " + repetitionLine.getNumber() + ": $" + repetitionLine.getPrice());
    }

    @Override
    public void visit(CancellationLine cancellationLine) {
        Console.instance().writeln("PrinterOperation: Cancellation " + cancellationLine.getNumber() + ": $" + cancellationLine.getPrice());
    }

    @Override
    public void visit(Footer footer) {
        Console.instance().writeln("PrinterOperation: Footer: " + footer.getTotalPrice());
    }
}
