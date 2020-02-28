import java.math.BigDecimal;
import java.text.NumberFormat;

public class PremiumSubscription extends Subscription {
    final private BigDecimal premiumRate = BigDecimal.valueOf(2.5);


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
}