package tickets.menu;

public class ExitCommand extends Command {

    private Boolean closed;

    public ExitCommand() {
        super("Exit");
        closed = Boolean.FALSE;
    }

    @Override
    public void execute() {
        ticket.close();
        closed = Boolean.TRUE;
    }

    public boolean isClosed() {
        return closed;
    }
}
