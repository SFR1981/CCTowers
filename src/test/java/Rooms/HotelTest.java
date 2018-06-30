package Rooms;

import Rooms.subRooms.BedRoom;
import Rooms.subRooms.ConferenceRoom;
import Rooms.subRooms.DiningRoom;
import Rooms.subRooms.RoomType;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import static org.junit.Assert.*;

public class HotelTest {
    Guest guest;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Hotel hotel;
    BedRoom bedRoom;
    DiningRoom diningRoom;
    ConferenceRoom conferenceRoom;

    @Before
    public void before(){
        hotel = new Hotel();
        guest = new Guest("Harry");
        guest2 = new Guest("Sheila");
        guest3 = new Guest("Bobo");
        guest4 = new Guest("Jess");
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
        hotel.addConferenceRooms(conferenceRoom);
        hotel.checkGuestInto(guest, conferenceRoom);
        assertEquals(1,conferenceRoom.getGuestnumber());
        assertEquals(150 , guest.getWallet());
        assertEquals(150, hotel.getTill());
        assertEquals("function suite", guest.whatRoom());
    }

    @Test
    public void cantCheckTooManyIntoRoom(){
        hotel.addBedRooms(bedRoom);
        hotel.checkGuestInto(guest, bedRoom);
        hotel.checkGuestInto(guest2, bedRoom);
        hotel.checkGuestInto(guest3, bedRoom);
        assertEquals("error: not checked into a room", guest3.whatRoom());
        assertEquals(2, bedRoom.getGuestnumber());
    }

    @Test
    public void cantCheckGuestOutOfRoom(){
        hotel.checkGuestOutOfRoom(guest, conferenceRoom);
        assertEquals(0, conferenceRoom.getGuestnumber());

    }

    @Test
    public void canCheckGuestOutOfRoom(){
        hotel.addBedRooms(bedRoom);
        hotel.checkGuestInto(guest, bedRoom);
        hotel.checkGuestOutOfRoom(guest, bedRoom);
        assertEquals(0, bedRoom.getGuestnumber());
        assertEquals("error: not checked into a room", guest.whatRoom());
    }

    @Test
    public void canGetListWhenRoomEmpty(){
        hotel.addBedRooms(bedRoom);
        assertEquals("room contains nobody",hotel.getGuestsInRoom(bedRoom));
    }

    @Test
    public void canGetListWhenRoomOccupied(){
        hotel.addBedRooms(bedRoom);
        hotel.checkGuestInto(guest, bedRoom);
        hotel.checkGuestInto(guest2, bedRoom);
        assertEquals("room contains Harry ,Sheila", hotel.getGuestsInRoom(bedRoom));
        System.out.println(hotel.getTill());

    }

    @Test
    public void canSeeListVacantBedrooms(){
        hotel.addBedRooms(bedRoom);
        BedRoom bedRoom2 = new BedRoom("2",2,RoomType.DOUBLE);
        BedRoom bedRoom3 = new BedRoom("3",2,RoomType.DOUBLE);
        BedRoom bedRoom4 = new BedRoom("4",1,RoomType.SINGLE);
        BedRoom bedRoom5 = new BedRoom("5",4,RoomType.FAMILY);
        BedRoom bedRoom6 = new BedRoom("237",4,RoomType.FAMILY);
        hotel.addBedRooms(bedRoom2);
        hotel.addBedRooms(bedRoom3);
        hotel.addBedRooms(bedRoom4);
        hotel.addBedRooms(bedRoom5);
        hotel.addBedRooms(bedRoom6);
        hotel.checkGuestInto(guest, bedRoom);
        hotel.checkGuestInto(guest2, bedRoom);
        hotel.checkGuestInto(guest3, bedRoom4);
        hotel.checkGuestInto(guest4, bedRoom5);
        assertEquals("available rooms: 2, 3, 237", hotel.getVacantRooms());

    }

    @Test
    public void noVacancies(){
        BedRoom bedRoom6 = new BedRoom("237",4,RoomType.FAMILY);
        hotel.addBedRooms(bedRoom6);
        hotel.checkGuestInto(guest, bedRoom6);
        assertEquals("no vacancies", hotel.getVacantRooms());

    }

    @Test
    public void cantAffordToBookForThreeNights(){
        BedRoom bedRoom6 = new BedRoom("237",4,RoomType.FAMILY);
        hotel.addBedRooms(bedRoom6);
        hotel.checkGuestIntoBedRoomForStayLength(guest2, bedRoom6, 3);
        System.out.println(bedRoom6.getBookedUntil());

    }

    @Test
    public void canBookForTwoNights(){
        hotel.addBedRooms(bedRoom);
        hotel.checkGuestIntoBedRoomForStayLength(guest, bedRoom, 2);
        System.out.println(bedRoom.getBookedUntil());
        assertEquals(Date.from(Instant.now().plusSeconds(86400*2).truncatedTo(ChronoUnit.DAYS)), bedRoom.getBookedUntil());
    }




}