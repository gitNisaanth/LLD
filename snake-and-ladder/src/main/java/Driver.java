import model.Board;
import model.Player;
import service.BoardGeneratorService;
import service.SnlGameService;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        BoardGeneratorService boardGeneratorService = new BoardGeneratorService();
        Board board = boardGeneratorService.generateBoard(20, 1, 1);
        System.out.println(board.getSnakes().get(0).getHead());
        System.out.println(board.getSnakes().get(0).getTail());
        System.out.println(board.getLadders().get(0).getStart());
        System.out.println(board.getLadders().get(0).getEnd());
        List<Player> playerList = new ArrayList<>();
        Player player1 = new Player("Nissy");
        Player player2 = new Player("Vasu");
        playerList.add(player1);
        playerList.add(player2);

        SnlGameService snlGameService = new SnlGameService(board, playerList, null);
        snlGameService.startGame();
    }
}
