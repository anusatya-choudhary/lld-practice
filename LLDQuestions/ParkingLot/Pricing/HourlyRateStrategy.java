package Pricing;

import java.time.LocalDateTime;
import java.time.Duration;
import Core.Ticket;

//Fixing the cost of the parking lot to be Rs 50 per 30 minutes

public class HourlyRateStrategy implements PricingStrategy {
    public double calculateCost(Ticket ticket) {
        LocalDateTime entryTime  = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();

        Duration duration = Duration.between(entryTime, exitTime);

        long thirtyMinuteIntervals = duration.toMinutes() / 30;
        return thirtyMinuteIntervals * 50.0;
    }
}
