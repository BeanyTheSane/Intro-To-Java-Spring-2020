import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class PremiumSubscription extends Subscription {
    final private BigDecimal premiumRate = BigDecimal.valueOf(2.5);
    final private Long premiumSubscriptionLengthInYears = (long) 3;

    public PremiumSubscription(Subscriber subscriber) {
        super(subscriber);
    }
    
    public BigDecimal costOfRenewalRaw() {
        return super.cost.multiply(premiumRate);
    }

    public String foramttedCostOfRenewal() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(costOfRenewalRaw());
    }

    public String getExpirationDate() {
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return this.startDate.plusYears(premiumSubscriptionLengthInYears).format(shortDate);
    }
}