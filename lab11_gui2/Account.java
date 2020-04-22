import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Account {
    private BigDecimal balance;
    private List<Transaction> history;

    public Account() {
        balance = BigDecimal.valueOf(0);
        history = new ArrayList<>();
    }

    public List<Transaction> getHistory() {
        return this.history;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void deposit(BigDecimal depositAmount, String description) throws AccountException { 
		final Pattern regexPattern = Pattern.compile("^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{1,2})?$");
        if (BigDecimal.valueOf(0).compareTo(depositAmount) != -1) {
            throw new AccountException("Please enter a value greater than zero(0)");
        }
        if (!regexPattern.matcher(depositAmount.toString()).matches()) {
            throw new AccountException("Please use only two digits after the decimal");
        }
        this.balance = balance.add(depositAmount);
        history.add(new Transaction(depositAmount, "Deposit: " + description));
    }
    
    public void withdrawal(BigDecimal withdrawalAmount, String description) throws AccountException {
		final Pattern regexPattern = Pattern.compile("^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{1,2})?$");
        if (BigDecimal.valueOf(0).compareTo(withdrawalAmount) != -1) {
            throw new AccountException("Please enter a value greater than zero(0)");
        }
        if (!regexPattern.matcher(withdrawalAmount.toString()).matches()) {
            throw new AccountException("Please use only two digits after the decimal");
        }
        this.balance = balance.subtract(withdrawalAmount);
        history.add(new Transaction(withdrawalAmount, "Withdrawal: " + description));
    }

    public void miscellaneous(BigDecimal amount, String description) throws AccountException {
		final Pattern regexPattern = Pattern.compile("^[-]{0,1}[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{1,2})?$");
        if (BigDecimal.valueOf(0).compareTo(amount) == 0) {
            throw new AccountException("Please enter a value other than zero(0)");
        }
        if (!regexPattern.matcher(amount.toString()).matches()) {
            throw new AccountException("Please use only two digits after the decimal");
        }
            this.balance = balance.add(amount);
            history.add(new Transaction(amount, "Miscellaneous: " + description));
    }

}