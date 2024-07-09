package N1.Observable;



import N1.Observer.Observer;

public interface Observable {

    void addObserver(Observer observer);
    void notifyObservers();
}
