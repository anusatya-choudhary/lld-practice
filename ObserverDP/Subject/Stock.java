package ObserverDP.Subject;

import java.util.ArrayList;
import java.util.List;
import ObserverDP.Observer.StockObserver;

public class Stock implements Subject{
    private String symbol;
    private double price;
    private List<StockObserver> observers;

    public Stock(String sym, double price){
        this.symbol = sym;
        this.price = price;
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(StockObserver observer){
        observers.add(observer);
    }

    @Override
    public void unsubscribe(StockObserver observer){
        observers.remove(observer);
    }

    public void setPrice(double price){
        double oldPrice = this.price;
        this.price = price;
        notifyObservers(oldPrice, price);
    }

    @Override
    public void notifyObservers(double oldPrice, double newPrice){
        for(StockObserver observer : observers){
            observer.update(this, oldPrice, newPrice);
        }
    }

    public String getSymbol(){
        return symbol;
    }
}
