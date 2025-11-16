package ObserverDP.Subject;

import ObserverDP.Observer.StockObserver;

public interface Subject {
    void subscribe(StockObserver observer);
    void unsubscribe(StockObserver observer);
    void notifyObservers(double oldPrice, double newPrice);
}
