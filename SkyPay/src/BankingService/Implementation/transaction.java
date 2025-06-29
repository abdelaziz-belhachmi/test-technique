package BankingService.Implementation;

import BankingService.enums.TransactionType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class transaction {

    private final int amount;
    private final TransactionType type;
    private final Date transactionDate;
    private final int balanceAtTransaction;

    public transaction(int amount, TransactionType type,Date transactionDate,int balanceAtTransaction){
        this.amount = amount;
        this.type = type;
        this.transactionDate = transactionDate;
        this.balanceAtTransaction = balanceAtTransaction;
    }

    @Override
    public String toString() {
        int ammount = type == TransactionType.DEPOSIT ? amount : -amount;
        String formatedtransactionDate = new SimpleDateFormat("dd/MM/yyyy").format(transactionDate);
        return  formatedtransactionDate+ " ||  "+ ammount +"  || " + balanceAtTransaction;
    }

}
