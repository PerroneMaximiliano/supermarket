package tickets.store;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private static Store store;

    public static Store instance() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }

    private Map<Integer, Product> products;

    private Store() {
        products = new HashMap<Integer, Product>();
        for (int i=1; i <= 10; i++) {
            products.put(i, new Product(Double.valueOf(i),1000+i));
        }
    }

    public Double getPrice(int id, int units){
        return products.get(id).getPrice(units);
    }

    public void add(int id, int units) {
        products.get(id).add(units);
    }

    public void remove(int id, int units) {
        products.get(id).remove(units);
    }
}
