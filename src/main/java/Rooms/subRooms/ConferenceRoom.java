package Rooms.subRooms;

import Rooms.Room;

public class ConferenceRoom extends Room{

    int rate;

    public ConferenceRoom(String name, int capacity, int rate) {
        super(name, capacity);
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
