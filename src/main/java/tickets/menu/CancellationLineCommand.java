package tickets.menu;

import tickets.ticket.CancellationLine;
import tickets.ticket.Line;

public class CancellationLineCommand extends NumberLineCommand {

    public CancellationLineCommand() {
        super("CancellationLine");
    }

    @Override
    protected Line createLine(int line) {
        return new CancellationLine(line);
    }
}