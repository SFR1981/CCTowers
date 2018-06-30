package Rooms;

import Rooms.subRooms.BedRoom;
import Rooms.subRooms.ConferenceRoom;
import Rooms.subRooms.DiningRoom;

import java.time.Instant;
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

    public int getTill(){
        return till;
    }

    public void payTill(int rate){
        till += rate;
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

    public void checkGuestInto(Guest guest, Room room){
        if (conferenceRooms.contains(room)|| diningRooms.contains(room) || (bedRooms.contains(room))){
        if (room.getGuestnumber() < room.getCapacity()) {
            int rate = room.getRate();
            guest.pays(rate);
            this.payTill(rate);
            guest.checkInto(room);
            room.checkIn(guest);
        }

        }

    }


    public void checkGuestIntoBedRoomForStayLength(Guest guest, BedRoom room, int stay_length ){
        if (guest.getWallet() >= (room.getRate()*stay_length)) {
            this.checkGuestInto(guest, room);
            room.updateBooking(stay_length);
            int charge = stay_length - 1; //checking in charges for one night
            guest.pays(charge);
            this.payTill(charge);
        }

    }

    public void checkGuestOutOfRoom(Guest guest, Room room){
        if (room.getGuests().contains(guest)){
            room.checkOut(guest);
            guest.checkOutOf(room);
        }

    }


    public String getGuestsInRoom(Room room){
        ArrayList<String> guests = new ArrayList<>();
        for (Guest guest : room.getGuests()){
            guests.add(guest.getName());
        }
        if (guests.isEmpty()) {
            guests.add("nobody");
        }
        String guestString = String.join(" ,", guests);
        return "room contains "+ guestString;

    }

    public String getVacantRooms(){
        ArrayList<String> vacantRooms = new ArrayList<>();
        for (BedRoom room : bedRooms){
            if (room.getGuestnumber() == 0){
                String name = room.getName();
                vacantRooms.add(name);
            }
        }
        String vacancies = String.join(", " , vacantRooms);
        if (vacantRooms.isEmpty()){
            return "no vacancies";
        }
        else {
            return "available rooms: " + vacancies;
        }
    }





}
