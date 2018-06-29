package Rooms.subRooms;

import Rooms.Guest;
import Rooms.Room;

import java.time.Instant;
import java.util.Date;

public class BedRoom extends Room {

    RoomType type;
    int rate;
    Date bookedUntil;

    public BedRoom(String name, int capacity, RoomType type) {
        super(name, capacity);
        this.type = type;
        this.rate = type.getRate();
        this.bookedUntil = null;
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

    public Date bookedUntil(){
        return bookedUntil;
    }

    public void updateBooking(int stay_length){
        int stay_length_seconds = stay_length * (864000);
        Instant expiration = Instant.now().plusSeconds(stay_length_seconds);
        this.bookedUntil = Date.from(expiration);

    }


}
