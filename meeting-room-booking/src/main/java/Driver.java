import model.Room;
import model.RoomProperty;
import service.AdminService;
import service.EmployeeService;
import service.RoomBookingService;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        RoomBookingService roomBookingService = new RoomBookingService();
        AdminService adminService = new AdminService();
        EmployeeService employeeService = new EmployeeService();


        RoomProperty roomProperty = new RoomProperty(11,false,true);
        Room room1 = new Room(roomProperty);


        RoomProperty roomProperty2 = new RoomProperty(15,true,true);
        Room room2 = new Room(roomProperty2);


        adminService.setRoomBookingService(roomBookingService);
        adminService.initializeTheRooms(List.of(room1,room2));
        employeeService.setRoomBookingService(roomBookingService);

        RoomProperty inputRoomProperty = new RoomProperty(10,true,true);

        System.out.println("Room");
        List<Room> rooms = employeeService.searchRoom(inputRoomProperty, 10, 20);
        System.out.println(rooms.size());
        for (Room room : rooms) {
            String s = "Room Details: " + room.getId() + " capacity" + room.getRoomProperty().getCapacity();
        }

        if(rooms.size()!=0) {
            boolean successStatus = employeeService.bookRoom(rooms.get(0).getId(),5,20);
            System.out.println(successStatus);
        }


        List<Room>  roomsAvaialble = employeeService.searchRoom(inputRoomProperty, 5, 20);
        System.out.println(roomsAvaialble.size());

        if(roomsAvaialble.size()!=0) {
            boolean successStatus2 = employeeService.bookRoom(roomsAvaialble.get(0).getId(),10,20);
            System.out.println(successStatus2);
        }
    }

}
