package HotelReservationSystem.Entities;

import HotelReservationSystem.enums.RoomType;


public class Room {
    private int ID;
    private RoomType roomType;
    private int PricePerNight;

    /*
        I need this copy constructor
        inorder for me to keep snapshot of room details when booking is successfully done by a user.
    */
    public Room(Room room){
        this.ID = room.ID;
        this.roomType = room.roomType;
        this.PricePerNight = room.PricePerNight;
    }

    public Room(int ID, RoomType roomType, int pricePerNight) {
        this.ID = ID;
        this.roomType = roomType;
        PricePerNight = pricePerNight;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getPricePerNight() {
        return PricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        PricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{" +
                "ID=" + ID +
                ", roomType=" + roomType +
                ", PricePerNight=" + PricePerNight +
                '}';
    }
}
