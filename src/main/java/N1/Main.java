package N1;


import N1.Observable.Broker;
import N1.Observer.Agency;

public class Main {

    public static void main(String[] args) {

        Broker broker = new Broker("Broker");
        Agency agency = new Agency("Wall Street");

        broker.addObserver(agency);

        broker.setNewMovement();

        Agency agency2 = new Agency("Wall Street 2");
        broker.addObserver(agency2);
        broker.setNewMovement();

        Agency agency3 = new Agency("Wall Street 3");
        broker.setNewMovement();

    }


}
