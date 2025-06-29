package BankingService.tests;

import BankingService.Implementation.Account;

public class TestAccount {
    private Account singleAccount;

    public TestAccount(){
    }

    public void runTest1(){
        System.out.println(":: TestCase 1 :: as given in the Technical Test.");
        singleAccount = new Account();

        singleAccount.deposit(1000);
        singleAccount.deposit(2000);
        singleAccount.withdraw(500);

        System.out.println("\nPrint Statement :\n");
        singleAccount.printStatement();

        System.out.println("\n:: End of TestCase 1 ::\n");

    }

    public void runTest2(){
        System.out.println(":: TestCase 2 ::");
        singleAccount = new Account();

        singleAccount.deposit(1000);
        singleAccount.withdraw(4500);
        singleAccount.withdraw(-500);
        singleAccount.deposit(-2000);

        System.out.println("\nPrint Statement :\n");
        singleAccount.printStatement();

        System.out.println("\n:: End of TestCase 2 ::\n");

    }


    public void runTest3(){
        System.out.println(":: TestCase 3 ::");
        singleAccount = new Account();

        singleAccount.withdraw(500);
        singleAccount.deposit(-500);
        singleAccount.deposit(500);
        singleAccount.withdraw(1000);
        singleAccount.withdraw(-100);

        System.out.println("\nPrint Statement:\n");
        singleAccount.printStatement();

        System.out.println("\n:: End of TestCase 3 ::\n");

    }

    public void runAllTests(){
        runTest1();
        runTest2();
        runTest3();
    }
}
