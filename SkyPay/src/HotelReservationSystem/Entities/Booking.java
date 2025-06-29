package HotelReservationSystem.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Booking {

    private final Room room; // takes copy instance only not the actual instance. 'snapshot of room instance at the booking time'
    private final User user; // reference instance
    private final Date checkin;
    private final Date checkout;
    private final Date BookingDoneAt;

    public Booking(Room room, User user, Date checkin, Date checkout) {
        this.room = new Room(room);
        this.user = user;
        this.checkin = checkin;
        this.checkout = checkout;
        this.BookingDoneAt = new Date();
    }

    public int getRoomid(){
        return room.getID();
    }

    public Date getCheckin() {
        return this.checkin;
    }


    public Date getCheckout() {
        return this.checkin;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", user=" + user +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", BookingDoneAt='" + BookingDoneAt + '\'' +
                '}';
    }


}
