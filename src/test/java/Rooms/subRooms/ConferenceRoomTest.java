package Rooms.subRooms;

import Rooms.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom("Function room", 100, 100);
        guest = new Guest("Martin");
    }

    @Test
    public void getRate() {
        assertEquals(100, conferenceRoom.getRate());
    }

    @Test
    public void getCapacity() {
        assertEquals(100, conferenceRoom.getCapacity());
    }

    @Test
    public void getGuestnumber() {
        assertEquals(0, conferenceRoom.getGuestnumber());
    }

    @Test
    public void getName() {
        assertEquals("Function room", conferenceRoom.getName());
    }

    @Test
    public void checkIn() {
        conferenceRoom.checkIn(guest);
        assertEquals(1, conferenceRoom.getGuestnumber());

    }

    @Test
    public void checkOut() {
        conferenceRoom.checkIn(guest);
        conferenceRoom.checkOut(guest);
        assertEquals(0, conferenceRoom.getGuestnumber());
    }
}