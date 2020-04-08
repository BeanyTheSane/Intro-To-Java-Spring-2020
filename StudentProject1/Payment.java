import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Payment {
    private BigDecimal paymentAmount;
    private LocalDateTime dateOfPayment;
    private String description;

    Payment(){}

    Payment(BigDecimal paymentAmount, LocalDateTime dateOfPayment, String description) 
    throws PaymentException {
        setPaymentAmount(paymentAmount);
        setDateOfPayment(dateOfPayment);
        setDescription(description);
    }

    public BigDecimal getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount)  
    throws PaymentException {
		final Pattern regexPattern = Pattern.compile("^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{1,2})?$");
		if (!regexPattern.matcher(paymentAmount.toString()).matches()) {
			throw new PaymentException("Please enter a payment amount equal to a dollar or more using the following format XXXX.XX");
		}
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

    public void setDescription(String description)  
    throws PaymentException {
		final Pattern regexPattern = Pattern.compile("^.{0,255}$");
		if (!regexPattern.matcher(paymentAmount.toString()).matches()) {
			throw new PaymentException("Please limit your description to 255 characters or less");
		}
        this.description = description;
    }
    
}