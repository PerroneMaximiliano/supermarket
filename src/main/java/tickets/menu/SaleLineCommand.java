package tickets.menu;

import tickets.ticket.Line;
import tickets.ticket.SaleLine;

public class SaleLineCommand extends IdLineCommand {

    public SaleLineCommand() {
        super("SaleLine");
    }

    @Override
    protected Line createLine(int id, int units) {
        return new SaleLine(id, units);
    }
}
