package Rooms;

import java.util.ArrayList;

public abstract class Room {

    protected ArrayList<Guest> guests;
    private int capacity;
    private String name;

    public Room(String name, int capacity){
        this.name = name;
        this.guests = new ArrayList<Guest>();
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getGuestnumber(){
        return guests.size();
    }


    public String getName(){
        return name;
    }

    public void checkIn(Guest guest){
        this.guests.add(guest);
    }

    public void checkOut(Guest guest) {
        if (this.guests.contains(guest)) {
            this.guests.remove(guest);
        }
    }




}
