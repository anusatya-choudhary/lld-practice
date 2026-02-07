package Pricing;

import Core.Ticket;

public class FixedRateStrategy implements PricingStrategy {
    public double calculateCost(Ticket ticket) {
        return 100.0;
    }
}
