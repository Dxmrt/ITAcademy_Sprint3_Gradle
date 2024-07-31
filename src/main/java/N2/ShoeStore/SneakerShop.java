package N2.ShoeStore;

import java.util.ArrayList;
import java.util.List;


public class SneakerShop {
    private final List<Sneakers> sneakersList;

    public SneakerShop() {
        this.sneakersList = new ArrayList<>();
        // Agregar algunos zapatos de ejemplo
        sneakersList.add(new Sneakers("Adidas", 100.0, 10));
        sneakersList.add(new Sneakers("Nike", 150.0, 5));
        sneakersList.add(new Sneakers("Buffalo", 200.0, 8));
    }

    public List<Sneakers> getSneakersList() {
        return sneakersList;
    }
}

