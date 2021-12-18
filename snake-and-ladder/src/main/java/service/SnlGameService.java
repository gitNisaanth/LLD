package service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Board;
import model.Ladder;
import model.Player;
import model.Snake;

public class SnlGameService {
    private final int totalPlayerCount;
    private final int boardSize;
    private final Map<Integer, Snake> snakeMap;
    private final Map<Integer, Ladder> ladderMap;
    private final Queue<Player> players;

    private final DiceService diceService;

    public SnlGameService(Board board, List<Player> players, Integer diceBound) {
        this.totalPlayerCount = players.size();
        this.boardSize = board.getSize();
        this.snakeMap = board.getSnakes().stream().collect(Collectors.toMap(Snake::getHead, Function.identity()));
        this.ladderMap = board.getLadders().stream().collect(Collectors.toMap(Ladder::getStart, Function.identity()));
        this.players = new LinkedList<>(players);
        this.diceService = diceBound == null ? new DiceService() : new DiceService(diceBound);
    }

    public void startGame() {
        System.out.println("Game Started");
        while (players.size() >= 2) {
            StringBuilder str = new StringBuilder();
            Player player = players.poll();
            int diceVal = diceService.rollDice();
            str.append(player.getName()).append(" rolled ").append(diceVal);
            int newPosition = computeNewPosition(player.getPosition(), diceVal, str);
            System.out.println(str);
            if (newPosition == boardSize) {
                int rank = totalPlayerCount - players.size();
                System.out.println("Player " + player.getName() + " has finished the game at rank " + rank);
            } else {
                player.setPosition(newPosition);
                players.add(player);
            }
        }
    }

    private int computeNewPosition(int startPos, int diceVal, StringBuilder str) {
        if (startPos + diceVal > boardSize) {
            str.append("\n").append("Invalid roll.");
            return startPos;
        }
        int currentPosition = startPos + diceVal;
        str.append(" and moved from ").append(startPos).append(" to ").append(currentPosition).append("\n");
        while (snakeMap.containsKey(currentPosition) || ladderMap.containsKey(currentPosition)) {
            if (snakeMap.containsKey(currentPosition)) {
                str.append("Got bitten by snake at ").append(currentPosition);
                currentPosition = snakeMap.get(currentPosition).getTail();
                str.append(" and moved to ").append(currentPosition).append("\n");
            } else {
                str.append("Climbed the ladder at ").append(currentPosition);
                currentPosition = ladderMap.get(currentPosition).getEnd();
                str.append(" and moved to ").append(currentPosition).append("\n");
            }
        }
        return currentPosition;
    }
}
