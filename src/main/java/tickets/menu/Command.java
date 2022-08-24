package tickets.menu;

import tickets.ticket.Ticket;

public abstract class Command {
    private String title;

    protected Ticket ticket;

    public Command(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void set(Ticket ticket) {
        this.ticket = ticket;
    }

    public abstract void execute();
}
