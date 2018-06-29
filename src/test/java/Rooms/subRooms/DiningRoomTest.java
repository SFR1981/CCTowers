package Rooms.subRooms;

import Rooms.Guest;
import Rooms.subRooms.BedRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiningRoomTest {

    DiningRoom restaurant;
    Guest guest;
    BedRoom bedroom;

    @Before
    public void before(){
        restaurant = new DiningRoom("Vino", 50);
        guest = new Guest("Barry");
        bedroom = new BedRoom("123",2, RoomType.DOUBLE);
    }

    @Test
    public void getCapacity() {
        assertEquals(50 ,restaurant.getCapacity());
    }

    @Test
    public void getGuestnumber(){
        assertEquals(0, restaurant.getGuestnumber());
    }

    @Test
    public void getName() {
        assertEquals("Vino", restaurant.getName());
    }

    @Test
    public void checkIn() {
        restaurant.checkIn(guest);
        assertEquals(1, restaurant.getGuestnumber());
    }

    @Test
    public void checkOut() {
        restaurant.checkIn(guest);
        restaurant.checkOut(guest);
        assertEquals(0, restaurant.getGuestnumber());
    }

    @Test
    public void roomsAreIndependent(){
        restaurant.checkIn(guest);
        bedroom.checkIn(guest);
        assertEquals(1, restaurant.getGuestnumber());
    }
}