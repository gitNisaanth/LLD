package model;

public class RoomProperty {
    private int capacity;
    private boolean hasProjector;
    private boolean hasWhiteBoard;

    public RoomProperty(int capacity, boolean hasProjector, boolean hasWhiteBoard) {
        this.capacity = capacity;
        this.hasProjector = hasProjector;
        this.hasWhiteBoard = hasWhiteBoard;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public boolean isHasWhiteBoard() {
        return hasWhiteBoard;
    }

    public void setHasWhiteBoard(boolean hasWhiteBoard) {
        this.hasWhiteBoard = hasWhiteBoard;
    }

    public boolean getIsRoomValid(RoomProperty roomProperty) {
        boolean isValid = roomProperty.getCapacity() <= this.capacity;
        if(roomProperty.isHasProjector()) {
            isValid = isValid && this.isHasProjector();
        }
        if(roomProperty.isHasWhiteBoard()) {
            isValid = isValid && this.isHasWhiteBoard();
        }
        return isValid;
    }
}
