package Rooms.subRooms;

import Rooms.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BedRoomTest {

    Guest guest;
    BedRoom bedRoom;

    @Before
    public void before(){
        guest = new Guest("Ian");
        bedRoom = new BedRoom("213", 2, RoomType.DOUBLE );
    }

    @Test
    public void canGetCapacity() {
        assertEquals(2, bedRoom.getCapacity());
    }

    @Test
    public void canCheckInGuest(){
        bedRoom.checkIn(guest);
        assertEquals(1, bedRoom.getGuestnumber());
    }

    @Test
    public void canGetGuestnumber() {
        assertEquals(0, bedRoom.getGuestnumber());


    }

    @Test
    public void getName() {
        assertEquals("213", bedRoom.getName());

    }


    @Test
    public void checkOut() {
        bedRoom.checkIn(guest);
        bedRoom.checkOut(guest);
        assertEquals(0, bedRoom.getGuestnumber());
    }

    @Test
    public void canGetWhoBookedRoom() {
        bedRoom.checkIn(guest);
        assertEquals("Ian", bedRoom.bookedBy());
    }

    @Test
    public void cantGetWhoBookedRoom(){
        assertEquals("room is vacant", bedRoom.bookedBy());
    }
}