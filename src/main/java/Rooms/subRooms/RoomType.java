package Rooms.subRooms;

public enum RoomType {
    SINGLE(40),
    DOUBLE(80),
    FAMILY(120),
    HONEYMOON(120),
    SUITE(120);

    private final int rate;


    RoomType(int rate){
        this.rate = rate;
    }

    public int getRate(){
        return this.rate;
    }
}
