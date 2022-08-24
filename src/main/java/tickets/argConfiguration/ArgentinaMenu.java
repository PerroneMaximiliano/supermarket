package tickets.argConfiguration;

import tickets.menu.*;

public class ArgentinaMenu extends Menu {

    @Override
    protected void setCommands() {
        commandList.add(new SaleLineCommand());
        commandList.add(new RepetitionLineCommand());
        commandList.add(new ReturnLineCommand());
        commandList.add(new CancellationLineCommand());
    }
}
