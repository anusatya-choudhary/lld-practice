package ObserverDP.Observer;

import ObserverDP.Subject.Stock;

public class IndividualInvestor implements StockObserver {
    private String name;
    private double thresholdChange;

    public IndividualInvestor(String name, double thresholdChange){
        this.name = name;
        this.thresholdChange = thresholdChange;
    }

    public String getName(){
        return name;
    }

    @Override
    public void update(Stock stock, double oldPrice, double newPrice){
        double percentageChange = ((newPrice - oldPrice) / oldPrice) * 100;
        if(Math.abs(percentageChange) >= thresholdChange){
            System.out.println("Individual Investor " + name + " received update for stock " + stock.getSymbol());
            System.out.println("Old price: " + oldPrice + " New price: " + newPrice);
            System.out.println("Percentage change: " + percentageChange + "%");
            System.out.println("--------------------------------");
            System.out.println();
        }
        else{
            System.out.println("Individual Investor " + name + " did not receive update for stock " + stock.getSymbol() + " because the percentage change is less than the threshold change");
            System.out.println("--------------------------------");
            System.out.println();
        }
    }
}
