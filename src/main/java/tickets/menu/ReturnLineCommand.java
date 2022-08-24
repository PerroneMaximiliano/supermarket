package tickets.menu;

import tickets.ticket.Line;
import tickets.ticket.ReturnLine;

public class ReturnLineCommand extends IdLineCommand {

    public ReturnLineCommand() {
        super("ReturnLine");
    }

    @Override
    protected Line createLine(int id, int units) {
        return new ReturnLine(id, units);
    }
}
