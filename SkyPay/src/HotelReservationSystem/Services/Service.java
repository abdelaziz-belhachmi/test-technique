package HotelReservationSystem.Services;

import HotelReservationSystem.Entities.Booking;
import HotelReservationSystem.Entities.Room;
import HotelReservationSystem.Entities.User;
import HotelReservationSystem.enums.RoomType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Service {
    private ArrayList<Room> rooms;
    private ArrayList<User> users;
    private ArrayList<Booking> Bookings;

    public Service() {
        this.rooms = new ArrayList<>();
        this.users = new ArrayList<>();
        this.Bookings = new ArrayList<>();
    }

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        Optional<Room> room = getRoombyIdIfExist(roomNumber);
        if (room.isPresent()) {
            Room roominstance = room.get();
            roominstance.setRoomType(roomType);
            roominstance.setPricePerNight(roomPricePerNight);
        }else{
            rooms.addLast(new Room(roomNumber, roomType, roomPricePerNight));
        }
    }

    private Optional<Room> getRoombyIdIfExist(int roomNumber) {
        if (! rooms.isEmpty()) {

            for (Room room : rooms) {
                if (room.getID() == roomNumber){
                return Optional.of(room);
                }
            }

        }
        return Optional.empty();
    }

    public void bookRoom(int userId, int roomNumber,Date checkIn,Date checkOut) {
        // edge cases
        if (!checkOut.after(checkIn)){
            throw new IllegalArgumentException(" -- Checkout Date cant be before checkin nor same day checking checkout ! User "+userId+" Selected checkin : " + checkIn + " checkout : " + checkOut);
        }
        if (! isRoomAvailableAt(roomNumber,checkIn,checkOut)){
            throw new IllegalArgumentException(" -- Cant reserve this room! Room not available for the chosen period From :"+checkIn+" || To :"+checkIn);
        }

        Optional<Room> room = getRoombyIdIfExist(roomNumber);
        Optional<User> user = getUserByIDifExist(userId);

        if (room.isPresent() && user.isPresent() ) {

            int roomPricePerNight = room.get().getPricePerNight();
            int numberOfNights = countNumberOfNights(checkIn,checkOut);
            int totalToPay = roomPricePerNight * numberOfNights;

            if ( user.get().getBalance() >= totalToPay ) {
                // bookin
                Bookings.addFirst(new Booking(room.get(),user.get(),checkIn,checkOut));
                // deducting price from user balance
                user.get().pay(totalToPay);

            }else {
                throw new IllegalArgumentException(" -- User dont have enough balance to pay for chosen room for the chosen period !\n"+
                        "\t Room : "+roomNumber+
                        "\n\t price Per Night : "+roomPricePerNight+
                        "\n\t number Of Nights : "+numberOfNights +
                        "\n\t Total to Pay : "+totalToPay+
                        "\n\t User Balance : "+user.get().getBalance()+" !\n"
                );
            }
        }else{
            throw new IllegalArgumentException("user id or room id is wrong");
        }

    }

    private int countNumberOfNights(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        long nights = diff / (1000 * 60 * 60 * 24);
        return (int) nights;
    }

    public void printAll() {
        // print all rooms data and bookings data both from the latest created to the oldest created.
        System.out.println("All Rooms Data :");
        for (Room room : rooms) {
            System.out.println(room);
        }

        System.out.println("\nAll Bookings Data :");
        for (Booking booking : Bookings) {
            System.out.println(booking);
        }
    }

    public void setUser(int userId, int balance) {
    Optional<User> user = getUserByIDifExist(userId);
        if (user.isPresent()) {
            user.get().changeBalance(balance);
        }else{
            users.addLast(new User(userId,balance));
        }
    }

    Optional<User> getUserByIDifExist(int userId) {
    if ( ! users.isEmpty()) {
        for (User user: users) {
            if (user.getUserId() ==userId){
                return Optional.of(user);
            }
        }
    }
        return Optional.empty();
    }

    public void printAllUsers() {
        System.out.println("printAllUsers :\n");
        for (User usr: users){
            System.out.println(usr);
        }
    }



    boolean isRoomAvailableAt(int roomID,Date startDate,Date endDate){
        for (Booking bk: Bookings){
            if (bk.getRoomid() == roomID){
                if (!(endDate.before(bk.getCheckin()) || startDate.after(bk.getCheckout()))) {
                    return false;
                }
            }
        }
        return true;
    }

}

