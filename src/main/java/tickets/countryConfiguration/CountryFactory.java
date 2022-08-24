package tickets.countryConfiguration;

import tickets.menu.Menu;
import tickets.ticket.Ticket;
import tickets.utils.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class CountryFactory {

    private static final String FILE = "tickets";
    private static CountryFactory countryFactory;

    public static CountryFactory instance() {
        if (countryFactory == null) {
            String line = CountryFactory.getSingletonConfigure();
            try {
                countryFactory = (CountryFactory) Class.forName(line).getDeclaredConstructor().newInstance();
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
        return countryFactory;
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

    public abstract Menu getMenu();

    public abstract Ticket getTicket();
}
