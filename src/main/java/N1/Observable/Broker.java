package N1.Observable;

import N1.Observer.Observer;

import java.util.ArrayList;

public class Broker implements Observable {

    private final ArrayList<Observer> observers = new ArrayList<>();
    private int balanceValue = 0;

    public Broker(String name) {
    }

    public void setNewMovement() {
        balanceValue = balanceValue + 100;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balanceValue);
        }
    }
}