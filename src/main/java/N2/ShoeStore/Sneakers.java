package N2.ShoeStore;


public class Sneakers {
    private final String brand;
    private final String model;
    private final int size;
    private final double price;
    private int stock;

    public Sneakers(String brand, String model, int size) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.price = 100.0; // Default price, can be adjusted
        this.stock = 10; // Default stock, can be adjusted
    }

    public Sneakers(String brand, String model, int size, double price, int stock) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.price = price;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Brand = " + brand + ", Model = " + model + ", Size = " + size + ", Price = " + price + ", Stock = " + stock;
    }
}

