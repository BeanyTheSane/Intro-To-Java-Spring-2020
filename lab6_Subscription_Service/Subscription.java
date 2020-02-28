import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Subscription {
    protected Subscriber subscriber;
    protected LocalDateTime startDate;
    final protected BigDecimal cost = BigDecimal.valueOf(20);  
    final protected Long subscriptionLengthInYears = (long) 1;

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

    public String getExpirationDate() {
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return this.startDate.plusYears(this.subscriptionLengthInYears).format(shortDate);
    }
}