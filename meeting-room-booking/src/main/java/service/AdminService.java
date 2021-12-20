package service;

import model.Room;
import model.RoomProperty;
import model.UserDetails;

import java.util.List;

public class AdminService {
    private RoomBookingService roomBookingService;

    public RoomBookingService getRoomBookingService() {
        return roomBookingService;
    }

    public void setRoomBookingService(RoomBookingService roomBookingService) {
        this.roomBookingService = roomBookingService;
    }

    public List<Room> searchRoom(RoomProperty roomProperty, int start, int end) {
        return roomBookingService.searchRoom(roomProperty, start, end);
    }

    public boolean initializeTheRooms(List<Room> rooms) {
        return roomBookingService.initializeRooms(rooms);
    }

    public boolean addRoom(Room room) {
        return roomBookingService.addRoom(room);
    }

    public boolean removeRoom(String roomId) {
        return roomBookingService.deleteRoom(roomId);
    }
}
