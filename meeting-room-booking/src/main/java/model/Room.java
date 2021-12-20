package model;

import java.util.HashMap;
import java.util.UUID;

public class Room {
    private final String id;
    private HashMap<Integer, RoomStatus> roomStatus;
    private RoomProperty roomProperty;

    public Room(RoomProperty roomProperty) {
        this.id = UUID.randomUUID().toString();
        this.roomStatus = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            roomStatus.put(i, RoomStatus.AVAILABLE);
        }
        this.roomProperty = roomProperty;
    }

    public String getId() {
        return id;
    }

    public HashMap<Integer, RoomStatus> getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(HashMap<Integer, RoomStatus> roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomProperty getRoomProperty() {
        return roomProperty;
    }

    public void setRoomProperty(RoomProperty roomProperty) {
        this.roomProperty = roomProperty;
    }

    public boolean isAvailable(int startSlot, int endSlot) {
        for (int i = startSlot; i < endSlot; i++) {
            if (roomStatus.get(i).equals(RoomStatus.BOOKED)) return false;
        }
        return true;
    }
}
