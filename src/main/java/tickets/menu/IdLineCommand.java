package tickets.menu;

import tickets.ticket.Line;
import tickets.utils.LimitedIntDialog;

public abstract class IdLineCommand extends Command {

    public IdLineCommand(String title) {
        super(title);
    }

    @Override
    public void execute() {
        int id = LimitedIntDialog.instance().read("Code: ", 1000);
        int units = LimitedIntDialog.instance().read("Units: ", 1000);
        ticket.add(createLine(id, units));
    }

    protected abstract Line createLine(int id, int units);
}
