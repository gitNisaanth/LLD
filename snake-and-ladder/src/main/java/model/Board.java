package model;

import java.util.List;

public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(Integer size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size == null ? Constants.DEFAULT_BOARD_SIZE : size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }
}
