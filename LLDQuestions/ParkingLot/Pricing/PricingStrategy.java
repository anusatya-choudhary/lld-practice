package Pricing;

import Core.Ticket;

public interface PricingStrategy {
    double calculateCost(Ticket ticket);
}
