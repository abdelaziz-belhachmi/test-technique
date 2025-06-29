package BankingService.Implementation;

import BankingService.enums.TransactionType;
import BankingService.interfaces.AccountService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements AccountService {

    private int balance;
    List<transaction> transactions;


    public Account() {
        balance = 0; // initial balance 0
        transactions = new ArrayList<>();
    }

    private void logTransaction(int amount, TransactionType type,int newBalance){
        transactions.addFirst(new transaction(amount,type,new Date(),newBalance));
    }

    @Override
    public void deposit(int amount) {
        try {
            if(amount == 0){
                throw new IllegalArgumentException(" -- Deposit amount should not be 0.");
            }
            if (amount < 0) {
                throw new IllegalArgumentException(" -- Deposit amount must be positive. tried to deposit: " + amount + " !");
            } else {
                balance += amount;
                logTransaction(amount, TransactionType.DEPOSIT, balance);
                System.out.println(" ++ Successfully Deposit "+amount+".");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(int amount) {
        try {
            // edge cases
            if(amount == 0){
                throw new IllegalArgumentException(" -- Can't Withdraw 0 !");
            }
            if (amount < 0) {
                throw new IllegalArgumentException(" -- Can't withdraw negative amount ("+amount+") !");
            } else if (amount > balance) {
                throw new IllegalArgumentException(" -- insufficient Balance to withdraw. Balance :"+balance+" tried to widthraw :"+amount+" !");
            } else {
                balance -= amount;
                logTransaction(amount, TransactionType.WITHDRAW, balance);
                System.out.println(" ++ Successfully Withdrawn "+amount+".");

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



    @Override
    public void printStatement() {
        System.out.println("Date\t   || amount || Balance");
        for(transaction tr : transactions){
            System.out.println(tr);
        }


    }
}
