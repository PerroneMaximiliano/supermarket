package tickets.brazilConfiguration;

import tickets.menu.*;

public class BrazilMenu extends Menu {

    @Override
    protected void setCommands() {
        commandList.add(new SaleLineCommand());
        commandList.add(new RepetitionLineCommand());
        commandList.add(new CancellationLineCommand());
    }
}
