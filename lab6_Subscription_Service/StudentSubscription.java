import java.math.BigDecimal;
import java.text.NumberFormat;

public class StudentSubscription extends Subscription {
    final private BigDecimal studentRate = BigDecimal.valueOf(.75);

    public StudentSubscription(Subscriber subscriber) {
        super(subscriber);
    }
    
    public BigDecimal costOfRenewalRaw() {
        return super.cost.multiply(studentRate);
    }

    public String foramttedCostOfRenewal() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(costOfRenewalRaw());
    }
    
}