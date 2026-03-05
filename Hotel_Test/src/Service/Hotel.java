package Service;

import model.Room;
import model.RoomType;

import java.util.Map;
import java.util.TreeMap;

public class Hotel {

    private Map<Integer, Room> rooms;

    public Hotel() {
        rooms = new TreeMap<>();
        initializeRooms();
    }

    private void initializeRooms() {
        RoomType[] types = {RoomType.Single, RoomType.Double, RoomType.Deluxe, RoomType.Suite};
        for(int i=1; i<5; i++){
            RoomType type = types[i-1];
            for(int j=1; j<7; j++){
                int roomNumber = i*100 + j;
                rooms.put(roomNumber,new Room(roomNumber, type));
            }

        }
        for (Integer key : rooms.keySet()) {
            System.out.println(key + "호: " + rooms.get(key).getRoomType() + " (" + rooms.get(key).getRoomType().getDefaultPrice() + "원)");
        }
    }
}
