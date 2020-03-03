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
    
    public String toString() {
        StringBuilder subscriptionDetails = new StringBuilder();
        subscriptionDetails.append(this.getSubscriber().getFullName());
        subscriptionDetails.append("; School: ");
        subscriptionDetails.append(this.getSubscriber().getSchoolName());
        subscriptionDetails.append("; Subscription Expires ");
        subscriptionDetails.append(this.getExpirationDate());
        subscriptionDetails.append(". Cost To Renew: ");
        subscriptionDetails.append(this.foramttedCostOfRenewal());
        return subscriptionDetails.toString();
    }
}