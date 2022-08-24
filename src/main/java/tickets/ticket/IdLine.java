package tickets.ticket;

public abstract class IdLine extends Line {
    protected int id;

    protected int units;

    protected IdLine(int id, int units) {
        this.id = id;
        this.units = units;
    }

    public int getId() {
        return id;
    }

    public int getUnits() {
        return units;
    }
}
