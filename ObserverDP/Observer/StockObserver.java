package ObserverDP.Observer;

import ObserverDP.Subject.Stock;

public interface StockObserver {
    void update(Stock stock, double oldPrice ,double newPrice);
    String getName();
}
