package ObserverDP.Subject;
import java.util.ArrayList;
import java.util.List;
import ObserverDP.Observer.StockObserver;


public class Stock implements Subject{
    private String symbol;
    private double price;
    private double oldPrice;
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
        oldPrice = this.price;
        this.price = price;
        notifyObservers();
    }

    @Override
    public void notifyObservers(){
        for(StockObserver observer : observers){
            observer.update(this, oldPrice, price);
        }
    }

    public String getSymbol(){
        return symbol;
    }
}
