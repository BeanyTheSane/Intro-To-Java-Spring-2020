import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;

public class Subscription {
    protected Subscriber subscriber;
    protected LocalDateTime startDate;
    final protected BigDecimal cost = BigDecimal.valueOf(20);    

    Subscription(Subscriber subscriber) {
        this.subscriber = subscriber;
        this.startDate = LocalDateTime.now();
    }

    public Subscriber getSubscriber() {
        return this.subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public BigDecimal costOfRenewalRaw() {
        return this.cost;
    }

    public String foramttedCostOfRenewal() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(costOfRenewalRaw());
    }
}