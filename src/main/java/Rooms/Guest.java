package Rooms;

import java.util.ArrayList;

public class Guest {

    private String name;
    private int wallet;
    private ArrayList<Room> room;

    public Guest(String name){
        this.name = name;
        this.wallet = 300;
        this.room = new ArrayList<Room>();
    }


    public String getName(){
        return this.name;
    }

    public int getWallet(){
        return this.wallet;
    }


    public String whatRoom() {
        if (room.size() == 1) {
            Room staying = this.room.get(0);
            return staying.getName();
        }
        return "error: not checked into a room";
    }

    public void checkOutOf(Room oldRoom){
        room.remove(oldRoom);
    }

    public void checkedInto(Room newRoom){
        room.add(newRoom);


    }





}
