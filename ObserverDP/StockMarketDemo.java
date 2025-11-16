package ObserverDP;

import ObserverDP.Observer.IndividualInvestor;
import ObserverDP.Observer.InstitutionalInvestor;
import ObserverDP.Observer.StockExchange;
import ObserverDP.Observer.StockObserver;
import ObserverDP.Subject.Stock;

public class StockMarketDemo {
    public static void main(String[] args) {
        Stock stock = new Stock("Reliance", 150.0);

        StockObserver individualInvestor = new IndividualInvestor("Anusatya", 5.0);
        StockObserver institutionalInvestor = new InstitutionalInvestor("Kotak AMC");
        StockObserver stockExchange = new StockExchange("BSE");

        stock.subscribe(individualInvestor);
        stock.subscribe(institutionalInvestor);
        stock.subscribe(stockExchange);
        
        stock.setPrice(155.0);
        stock.setPrice(152.5);
        stock.setPrice(180.0);

        Stock newStock = new Stock("Microcap stock", 1000.0);
        newStock.subscribe(institutionalInvestor);
        newStock.subscribe(institutionalInvestor);
        newStock.subscribe(stockExchange);

        newStock.setPrice(1005.0);
        newStock.setPrice(1002.5);
        
    }
}
