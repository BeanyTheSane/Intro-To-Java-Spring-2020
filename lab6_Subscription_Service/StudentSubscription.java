import java.math.BigDecimal;
import java.text.NumberFormat;

public class StudentSubscription extends Subscription {
    final private BigDecimal studentRate = BigDecimal.valueOf(.75);

    public StudentSubscription(Subscriber studentSubscriber) {
        super(studentSubscriber);
    }

    public StudentSubscriber getSubscriber() {
        return (StudentSubscriber) this.subscriber;
    }

    public void setSubscriber(StudentSubscriber studentSubscriber) {
        this.subscriber = studentSubscriber;
    }

    public BigDecimal costOfRenewalRaw() {
        return super.cost.multiply(studentRate);
    }

    public String foramttedCostOfRenewal() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(costOfRenewalRaw());
    }

    public BigDecimal getRate() {
        return this.studentRate;
    }
}