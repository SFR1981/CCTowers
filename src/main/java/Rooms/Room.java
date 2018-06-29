package Rooms;

import java.util.ArrayList;

public abstract class Room {

    private ArrayList<Guest> guests;
    private int capacity;
    private String name;

    public Room(String name, int capacity){
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




}
