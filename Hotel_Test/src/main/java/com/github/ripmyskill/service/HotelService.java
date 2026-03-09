package com.github.ripmyskill.service;

import com.github.ripmyskill.model.Room;
import com.github.ripmyskill.model.RoomType;

import java.util.Map;
import java.util.TreeMap;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class HotelService {

    private Map<Integer, Room> rooms;

    public HotelService() {
        rooms = new TreeMap<>();
        initializeRooms();
    }

    private void initializeRooms() {
        RoomType[] types = {RoomType.SINGLE, RoomType.DOUBLE, RoomType.DELUXE, RoomType.SUITE};
        for(int i=1; i<=4; i++) {
            RoomType type = types[i - 1];
            for (int j = 1; j <= 6; j++) {
                int roomNumber = i * 100 + j;
                rooms.put(roomNumber, new Room(roomNumber, type));
            }
        }

        }

    public void showRoomGrid() {
        System.out.println("\n"+"=".repeat(102));
        System.out.println(" ".repeat(43)+"호텔 객실 현황판");
        System.out.println("=".repeat(102));

        int currentFloor = 0;

        for (Room room : rooms.values()) {
            int floor = room.getRoomNo() / 100;

            if (floor != currentFloor) {
                if (currentFloor != 0) System.out.println();
                System.out.println(ansi().fg(WHITE).bold().a(floor + "F | ").reset());
                currentFloor = floor;
            }

            Ansi roomAnsi = ansi();
            String statusLabel;

            switch (room.getRoomStatus()) {
                case AVAILABLE -> {
                    roomAnsi.fg(GREEN);
                    statusLabel = "빈방";
                }
                case OCCUPIED -> {
                    roomAnsi.fg(RED);
                    statusLabel = "만실";
                }
                case CLEANING -> {
                    roomAnsi.fg(YELLOW);
                    statusLabel = "청소중";
                }
                default -> {
                    roomAnsi.fg(DEFAULT);
                    statusLabel = "확인";
                }
            }

            String roomInfo = String.format("%d:%s(%s)", room.getRoomNo(), room.getRoomType(), statusLabel);
            System.out.print(roomAnsi.a(String.format("%-16s", roomInfo)).reset());
        }

        System.out.println("\n"+"=".repeat(102));
        System.out.println("상태: " +
                ansi().fg(GREEN).a("예약가능 ").reset() +
                ansi().fg(RED).a("예약됨 ").reset() +
                ansi().fg(YELLOW).a("청소중").reset());
        System.out.println("=".repeat(102));
    }

    public Room findRoom(int roomNo) {
        return rooms.get(roomNo);
    }

    public Map<Integer, Room> getRooms() {
        return rooms;
    }
}
