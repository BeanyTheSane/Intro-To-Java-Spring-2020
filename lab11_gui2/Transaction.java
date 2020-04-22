import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private Date transDate;
    private String amount;
    private String description;

    public Transaction(BigDecimal amount, String description) {
        this.transDate = Calendar.getInstance().getTime();
        this.amount = amount.toString();
        this.description = description;
    }


    public Date getTransDate() {
        return this.transDate;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        String amountToDisplay = "";
        if (getDescription().startsWith("Withdrawal")) {
            amountToDisplay =  currencyFormatter.format((Double.parseDouble(getAmount())*-1));
        } else {
            amountToDisplay = currencyFormatter.format(Double.parseDouble(getAmount()));
        }
        return getTransDate() + "       " + amountToDisplay + "       " + getDescription();
    }
}