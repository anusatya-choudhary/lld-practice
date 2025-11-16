package ObserverDP.Observer;

import ObserverDP.Subject.Stock;

public class StockExchange implements StockObserver {
    private String name;

    public StockExchange(String name){
        this.name = name;
    }

    @Override
    public void update(Stock stock, double oldPrice, double newPrice){
        System.out.println("Stock Exchange " + name + " received update for stock " + stock.getSymbol());
        System.out.println("Old price: " + oldPrice + " New price: " + newPrice);
        System.out.println("--------------------------------");
        System.out.println();
    }
}
