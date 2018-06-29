package Rooms;

import Rooms.subRooms.BedRoom;
import Rooms.subRooms.ConferenceRoom;
import Rooms.subRooms.DiningRoom;
import Rooms.subRooms.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {
    Guest guest;
    Hotel hotel;
    BedRoom bedRoom;
    DiningRoom diningRoom;
    ConferenceRoom conferenceRoom;

    @Before
    public void before(){
        hotel = new Hotel();
        guest = new Guest("Harry");
        bedRoom = new BedRoom("1", 2, RoomType.DOUBLE);
        diningRoom = new DiningRoom("Little Chef", 50);
        conferenceRoom = new ConferenceRoom("function suite", 30, 150);

    }


    @Test
    public void checkRooms(){
        assertEquals(0, hotel.getBedRooms());
        assertEquals(0, hotel.getConferenceRooms());
        assertEquals(0, hotel.getDiningRooms());
    }

    @Test
    public void canAddBedRooms() {
        hotel.addBedRooms(bedRoom);
        assertEquals(1,hotel.getBedRooms() );
    }

    @Test
    public void canAddDiningRooms() {
        hotel.addConferenceRooms(conferenceRoom);
        assertEquals(1, hotel.getConferenceRooms());
    }

    @Test
    public void canAddConferenceRooms() {
        hotel.addConferenceRooms(conferenceRoom);
        assertEquals(1, hotel.getConferenceRooms());
    }

    @Test
    public void canRemoveBedRoom() {
        hotel.addBedRooms(bedRoom);
        hotel.removeBedRoom(bedRoom);
        assertEquals(0, hotel.getBedRooms());
    }

    @Test
    public void canRemoveDiningRoom() {
        hotel.addDiningRooms(diningRoom);
        hotel.removeDiningRoom(diningRoom);
        assertEquals(0, hotel.getBedRooms());
    }

    @Test
    public void canRemoveConferenceRoom() {
        hotel.addConferenceRooms(conferenceRoom);
        hotel.removeConferenceRoom(conferenceRoom);
        assertEquals(0, hotel.getConferenceRooms());
    }

    @Test
    public void canCheckGuestIntoRoom(){
        hotel.checkGuestInto(guest, conferenceRoom);
        assertEquals(1,conferenceRoom.getGuestnumber());
        assertEquals(150 , guest.getWallet());
        assertEquals(150, hotel.getTill());
        assertEquals("function suite", guest.whatRoom());
    }

    @Test
    public void canCheckGuestOutOfRoom(){

    }
}