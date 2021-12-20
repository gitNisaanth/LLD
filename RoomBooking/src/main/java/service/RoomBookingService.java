package service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import kotlin.jvm.Synchronized;
import model.Room;
import model.RoomProperty;
import model.RoomStatus;

public class RoomBookingService {
    private List<Room> roomList;

    private static RoomBookingService bookingService = null;

    public static RoomBookingService RoomBookingService() {
        if(bookingService == null) {
            bookingService = new RoomBookingService();
        }
        return bookingService;
    }

    public List<Room> searchRoom(RoomProperty roomProperty, int startSlot, int endSlot) {
        List<Room> rooms =  this.roomList.stream()
                .filter(it -> it.getRoomProperty().getIsRoomValid(roomProperty) && it.isAvailable(startSlot, endSlot))
                .collect(Collectors.toList());
        return rooms;
    }



    @Synchronized
    public boolean bookRoom(String roomId, int startSlot, int endSlot) {
        Room room = roomList.stream().filter(it -> it.getId().equals(roomId)).collect(Collectors.toList()).get(0);
        if(!room.isAvailable(startSlot,endSlot)) return false;
        HashMap<Integer, RoomStatus> roomStatus = room.getRoomStatus();
        for (int i = startSlot; i < endSlot; i++) {
            roomStatus.put(i,RoomStatus.BOOKED);
        }
        return true;
    }

    public boolean cancelMeeting(String roomId, int startSlot, int endSlot) {
        Room room = roomList.stream().filter(it -> it.getId().equals(roomId)).collect(Collectors.toList()).get(0);
        if(room.isAvailable(startSlot,endSlot)) return false;
        HashMap<Integer, RoomStatus> roomStatus = room.getRoomStatus();
        for (int i = startSlot; i < endSlot; i++) {
            roomStatus.put(i,RoomStatus.AVAILABLE);
        }
        return true;
    }

    public boolean rescheduleMeeting(String roomId, int startSlot, int endSlot, int newStartSlot, int newEndSlot) {
        Room room = roomList.stream().filter(it -> it.getId().equals(roomId)).collect(Collectors.toList()).get(0);
        if(room.isAvailable(startSlot,endSlot)) return false;
        HashMap<Integer, RoomStatus> roomStatus = room.getRoomStatus();
        return bookRoom(roomId, newStartSlot,newEndSlot);
    }

    public boolean initializeRooms(List<Room> roomList) {
        this.roomList = roomList;
        return true;
    }

    public boolean addRoom(Room room) {
        this.roomList.add(room);
        return true;
    }

    public boolean deleteRoom(String roomId) {
        this.roomList = this.roomList.stream().filter(it -> !it.getId().equals(roomId)).collect(Collectors.toList());
        return true;
    }


}
