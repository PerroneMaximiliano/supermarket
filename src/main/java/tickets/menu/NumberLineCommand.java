package tickets.menu;

import tickets.ticket.Line;
import tickets.utils.LimitedIntDialog;

public abstract class NumberLineCommand extends Command {

    public NumberLineCommand(String title) {
        super(title);
    }

    @Override
    public void execute() {
        int max = ticket.lines();
        int line = LimitedIntDialog.instance().read("Line?: ", max);
        ticket.add(createLine(line));
    }

    protected abstract Line createLine(int line);
}
