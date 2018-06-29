package Rooms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestTest {

    Guest guest;

    @Before
    public void before(){
        guest = new Guest("Terry Christmas");

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
}