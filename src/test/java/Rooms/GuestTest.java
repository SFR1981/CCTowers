package Rooms;

import Rooms.subRooms.BedRoom;
import Rooms.subRooms.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestTest {

    Guest guest;
    BedRoom bedRoom;

    @Before
    public void before(){
        guest = new Guest("Terry Christmas");
        bedRoom = new BedRoom("123", 2, RoomType.SINGLE);

    }

    @Test
    public void canGetName() {
        assertEquals("Terry Christmas", guest.getName());
    }


    @Test
    public void getWallet() {
        assertEquals(300, guest.getWallet());
    }

    @Test
    public void whatRoom() {
        assertEquals("error: not checked into a room",guest.whatRoom());
    }

    @Test
    public void canPay(){
        guest.pays(5);
        assertEquals(295, guest.getWallet());
    }

    @Test
    public void canCheckIn(){
        guest.checkInto(bedRoom);
        assertEquals("123", guest.whatRoom());
    }

}