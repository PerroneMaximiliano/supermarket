package tickets.store;

public class Product {

    private Double price;

    private int stock;

    public Product(Double price, int stock) {
        this.price = price;
        this.stock = stock;
    }

    public Double getPrice(int units) {
        return price * units;
    }

    public void add(int units) {
        stock += units;
    }

    public void remove(int units) {
        stock -= units;
    }
}
