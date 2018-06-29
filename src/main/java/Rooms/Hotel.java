package Rooms;

import Rooms.subRooms.BedRoom;
import Rooms.subRooms.ConferenceRoom;
import Rooms.subRooms.DiningRoom;

import java.util.ArrayList;

public class Hotel {

    private int till;
    private ArrayList<BedRoom> bedRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;

    public Hotel(){
        this.till = 0;
        bedRooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        diningRooms = new ArrayList<>();
    }

    public int getBedRooms(){
        return bedRooms.size();
    }

    public int getConferenceRooms(){
        return conferenceRooms.size();
    }

    public int getDiningRooms(){
        return diningRooms.size();
    }


    public void addBedRooms(BedRoom room){
        bedRooms.add(room);


    }

    public void addDiningRooms(DiningRoom room){
        diningRooms.add(room);
    }

    public void addConferenceRooms(ConferenceRoom room){
        conferenceRooms.add(room);
    }

    public void removeBedRoom(BedRoom room){
        bedRooms.remove(room);
    }

    public void removeDiningRoom(DiningRoom room){
        diningRooms.remove(room);
    }
    public void removeConferenceRoom(ConferenceRoom room){
        conferenceRooms.remove(room);
    }





}
