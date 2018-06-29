package Rooms;

import Rooms.subRooms.BedRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {

    Hotel hotel;

    @Before
    public void before(){
        hotel = new Hotel();

    }


    @Test
    public void checkRooms(){
        assertEquals(0, hotel.getBedRooms());
        assertEquals(0, hotel.getConferenceRooms());
        assertEquals(0, hotel.getDiningRooms());
    }
}