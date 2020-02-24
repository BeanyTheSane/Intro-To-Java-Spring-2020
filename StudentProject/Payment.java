import java.time.LocalDateTime;

public class Payment {
    private Double paymentAmount;
    private LocalDateTime dateOfPayment;
    private String description;

    public Payment(Double paymentAmount, LocalDateTime dateOfPayment, String description) {
        this.paymentAmount = paymentAmount;
        this.dateOfPayment = dateOfPayment;
        this.description = description;
    }

    public Double getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
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