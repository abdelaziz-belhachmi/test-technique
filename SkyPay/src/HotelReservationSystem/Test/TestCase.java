package HotelReservationSystem.Test;

import HotelReservationSystem.Services.Service;
import HotelReservationSystem.enums.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCase {

    private Service service;
    private SimpleDateFormat simpledateformat;
    private Date checkIn;
    private Date checkOut;

    public TestCase() {
        this.service = new Service();
        this.simpledateformat =new SimpleDateFormat("dd/MM/yyyy");
    }

    public void test1() {
        // Create 3 rooms :
        service.setRoom(1, RoomType.JUNIOR_SUIT,1000);
        service.setRoom(2, RoomType.STANDARD_SUIT,2000);
        service.setRoom(3, RoomType.MASTER_SUIT,3000);

        // Create 2 users, with IDs 1 and 2 and balance 5000, 10000
        service.setUser(1,5000);
        service.setUser(2,10000);

        //User 1 tries booking Room 2 from 30/06/2026 to 07/07/2026 (7 nights)
        try {
            checkIn = simpledateformat.parse("30/06/2026");
            checkOut = simpledateformat.parse("07/07/2026");
            service.bookRoom(1,2,checkIn,checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //User 1 tries booking Room 2 from 07/07/2026 to 30/06/2026.
        try {
            checkIn = simpledateformat.parse("07/07/2026");
            checkOut = simpledateformat.parse("30/06/2026");
            service.bookRoom(1,2,checkIn,checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //User 1 tries booking Room 1 from 07/07/2026 to 08/07/2026 (1 night).
        try {
            checkIn = simpledateformat.parse("07/07/2026");
            checkOut = simpledateformat.parse("08/07/2026");
            service.bookRoom(1,1,checkIn,checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //User 2 tries booking Room 1 from 07/07/2026 to 09/07/2026 (2 nights).
        try {
            checkIn = simpledateformat.parse("07/07/2026");
            checkOut = simpledateformat.parse("09/07/2026");
            service.bookRoom(2,1,checkIn,checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //User 2 tries booking Room 3 from 07/07/2026 to 08/07/2026 (1 night).
        try {
            checkIn = simpledateformat.parse("07/07/2026");
            checkOut = simpledateformat.parse("08/07/2026");
            service.bookRoom(2,3,checkIn,checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // setRoom(1, suite, 10000).
        service.setRoom(1, RoomType.MASTER_SUIT,10000);

        // Give screenshots of printAll(...) and printAllUsers(...) of the end result.
        System.out.println("\n-- printAll() --\n");
        service.printAll();
        System.out.println("\n-- printAllUsers() --\n");
        service.printAllUsers();

    }



}
