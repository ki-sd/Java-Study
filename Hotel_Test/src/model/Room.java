package model;
import java.text.DecimalFormat;

public class Room {
    private int roomNo;
    private RoomType roomType;
    private long roomPrice;
    private boolean isAvailable;

    public Room (int roomNo, RoomType roomType){
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomPrice = roomType.getDefaultPrice();
        this.isAvailable = true;
    }
    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(this.roomPrice) + "원";
    }

    public RoomType getRoomType() {
        return roomType;
    }
}


