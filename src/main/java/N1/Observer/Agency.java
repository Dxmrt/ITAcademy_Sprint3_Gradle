package N1.Observer;

public class Agency implements Observer {
    private final String name;

    public Agency(String name) {
        this.name = name;
    }
    @Override
    public void update(int balanceValue) {
        System.out.println("The agency " + name + " has a new movement, it is worth " + balanceValue + "€");
    }
}