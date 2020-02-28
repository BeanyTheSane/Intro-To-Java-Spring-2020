import java.math.BigDecimal;
import java.text.NumberFormat;

public class StudentSubscription extends Subscription {
    final private BigDecimal studentRate = BigDecimal.valueOf(.75);
    private StudentSubscriber studentSubscriber;

    public StudentSubscription(StudentSubscriber studentSubscriber) {
        super();
        this.studentSubscriber = studentSubscriber;
    }

    public StudentSubscriber getSubscriber() {
        return this.studentSubscriber;
    }

    public void setSubscriber(StudentSubscriber studentSubscriber) {
        this.studentSubscriber = studentSubscriber;
    }

    public BigDecimal costOfRenewalRaw() {
        return super.cost.multiply(studentRate);
    }

    public String foramttedCostOfRenewal() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(costOfRenewalRaw());
    }
    
}