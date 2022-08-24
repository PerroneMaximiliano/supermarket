package tickets.menu;

import tickets.ticket.Ticket;
import tickets.utils.Console;
import tickets.utils.LimitedIntDialog;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Command> commandList;

    private ExitCommand exitCommand;

    public Menu() {
        commandList = new ArrayList<>();
        this.setCommands();
        exitCommand = new ExitCommand();
        commandList.add(exitCommand);
    }

    protected abstract void setCommands();

    public void execute(Ticket ticket) {
        this.set(ticket);
        do {
            this.write(ticket);
            int option = getOption();
            commandList.get(option).execute();
        } while (!exitCommand.isClosed());
    }

    private void set(Ticket ticket) {
        commandList.stream().forEach(command -> command.set(ticket));
    }

    private int getOption() {
        return LimitedIntDialog.instance().read("Option?: ", commandList.size()) - 1;
    }

    private void write(Ticket ticket) {
        Console.instance().writeln();
        Console.instance().writeln("---------------------");
        for (int i = 0; i < commandList.size(); i++) {
            Console.instance().writeln((i + 1) + ". " + commandList.get(i).getTitle());
        }

        Console.instance().writeln();
        Console.instance().writeln("--------- LINES ----------");
        ticket.write();
        Console.instance().writeln("---------------------");
    }
}
