import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private BigDecimal paymentAmount;
    private LocalDateTime dateOfPayment;
    private String description;

    Payment(BigDecimal paymentAmount, LocalDateTime dateOfPayment, String description) {
        this.paymentAmount = paymentAmount;
        this.dateOfPayment = dateOfPayment;
        this.description = description;
    }

    public BigDecimal getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getDateOfPayment() {
        return this.dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}