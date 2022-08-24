package tickets.countryConfiguration;

import tickets.operations.TicketOperation;
import tickets.ticket.Ticket;
import tickets.utils.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class TicketBuilder {

    private static final String FILE = "ticketBuilder";
    private static TicketBuilder ticketBuilder;

    public static TicketBuilder instance() {
        if (ticketBuilder == null) {
            String line = TicketBuilder.getSingletonConfigure();
            try {
                ticketBuilder = (TicketBuilder) Class.forName(line).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return ticketBuilder;
    }

    public static String getSingletonConfigure() {
        BufferedReader in = null;
        String line = null;
        try {
            in = new BufferedReader(new FileReader(FILE));
            line = in.readLine().substring(12);
        } catch (IOException ex) {
            Console.instance().writeln("IOException to open: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Console.instance().writeln("IOException to close: " + ex.getMessage());
                }
            }
        }
        return line;
    }

    protected TicketOperation lineTicketOperation;

    protected TicketOperation globalTicketOperation;

    public abstract Ticket build();
}
