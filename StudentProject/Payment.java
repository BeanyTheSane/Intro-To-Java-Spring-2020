import java.util.Date;

public class Payment {
    private int paymentAmount;
    private Date dateOfPayment;
    private String description;

    public Payment(int paymentAmount, Date dateOfPayment, String description) {
        this.paymentAmount = paymentAmount;
        this.dateOfPayment = dateOfPayment;
        this.description = description;
    }

    public int getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getDateOfPayment() {
        return this.dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}