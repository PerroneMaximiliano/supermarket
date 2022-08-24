package tickets.ticket;

public abstract class NumberLine extends Line {

    private int number;

    public NumberLine(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
