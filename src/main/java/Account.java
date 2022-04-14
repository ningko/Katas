import java.util.ArrayList;
import java.util.List;

public class Account {

    static final String HEADER = "Amount,Balance\n";
    private List<Transaction> transactions = new ArrayList<>();

    void deposit(int amount) {
        transactions.add(new Transaction(amount, false));
    }

    void withdraw(final int amount) {
        transactions.add(new Transaction(amount, true));
    }

    String printStatement() {
        var operation = "";
        var total = 0;

        for (Transaction transaction : transactions) {
            total = getTotal(total, transaction);

            operation += (transaction.isWithdraw ? "-" : "+")
                    + transaction.amount 
                    + "," 
                    + total 
                    + "\n";
        }

        return HEADER + operation.substring(0, operation.length() - 1);
    }

    private int getTotal(int total, Transaction transaction) {
        if (transaction.isWithdraw) {
            total -= transaction.amount;
        } else {
            total += transaction.amount;
        }
        return total;
    }
}

class Transaction {
    int amount = 0;
    boolean isWithdraw;

    public Transaction(int amount, boolean isWithdraw) {
        this.amount = amount;
        this.isWithdraw = isWithdraw;
    }
}