package service;

import model.Room;
import model.RoomProperty;
import model.UserDetails;

import java.util.List;

public class EmployeeService {
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

    public boolean bookRoom(String roomId, int startSlot, int endSlot) {
        return roomBookingService.bookRoom(roomId,startSlot,endSlot);
    }


    public boolean cancelMeeting(String roomId, int startSlot, int endSlot) {
        return roomBookingService.cancelMeeting(roomId, startSlot, endSlot);
    }

    public boolean rescheduleMeeting(String roomId, int startSlot, int endSlot, int newStartSlot, int newEndSlot) {
        return roomBookingService.rescheduleMeeting(roomId, startSlot, endSlot, newStartSlot, newEndSlot);
    }
}
