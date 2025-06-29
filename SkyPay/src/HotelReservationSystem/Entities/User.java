package HotelReservationSystem.Entities;

public class User {
    private final int UserId ;
    private int Balance;

    public User(int UserId) {
        this.UserId = UserId;
        this.Balance = 0;
    }

    public User(int UserId,int balance) {
        this.UserId = UserId;
        this.Balance = balance;
    }

    public int getUserId() {
        return this.UserId;
    }

    public boolean makeDeposit(int amount) {
        if (amount > 0){
            Balance += amount;
            return true;
        }
        return false;
    }

    public void changeBalance(int newBalance){
        this.Balance = newBalance;
    }

    public int getBalance() {
        return this.Balance;
    }

    public void pay(int amount) {
        this.Balance -= amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId='" + UserId + '\'' +
                ", Balance=" + Balance +
                '}';
    }
}
