package Rooms.subRooms;

import Rooms.Guest;
import Rooms.Room;

public class BedRoom extends Room {

    RoomType type;
    int rate;

    public BedRoom(String name, int capacity, RoomType type) {
        super(name, capacity);
        this.type = type;
        this.rate = type.getRate();
    }

    public String bookedBy(){
        if (guests.size() > 0) {
            Guest guest = guests.get(0);
            return guest.getName();
        }else{
            return "room is vacant";
        }
    }

    public int getRate() {
        return rate;
    }
}
