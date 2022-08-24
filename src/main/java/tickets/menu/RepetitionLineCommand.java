package tickets.menu;

import tickets.ticket.Line;
import tickets.ticket.RepetitionLine;

public class RepetitionLineCommand extends NumberLineCommand {

    public RepetitionLineCommand() {
        super("RepetitionLine");
    }

    @Override
    protected Line createLine(int line) {
        return new RepetitionLine(line);
    }
}