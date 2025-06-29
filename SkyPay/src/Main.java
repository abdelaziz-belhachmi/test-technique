import BankingService.tests.TestAccount;
import HotelReservationSystem.Test.TestCase;

public class Main {
    public static void main(String [] args){

        System.out.println("\nTest 1 :Account Service\n");
        TestAccount testBankingService = new TestAccount();
        testBankingService.runAllTests();

        System.out.println("\nTest 2 :Hotel Reservation System\n");
        TestCase HotelReservationSystemTest = new TestCase();
        HotelReservationSystemTest.test1();
    }
}
