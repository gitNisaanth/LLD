package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.Board;
import model.Ladder;
import model.Snake;

public class BoardGeneratorService {

    public Board generateBoard(int boardSize, int totalSnakes, int totalLadders) {
        List<Snake> snakeList = new ArrayList<>();
        List<Ladder> ladderList = new ArrayList<>();

        Set<Integer> slSet = new HashSet<>();
        Random random = new Random();
        while (totalLadders != 0) {
            int start = random.nextInt(boardSize - 1) + 1;
            if (slSet.contains(start))
                continue;
            int end = random.nextInt(boardSize - start) + start;
            slSet.add(start);
            ladderList.add(new Ladder(start, end));
            totalLadders--;
        }
        while (totalSnakes != 0) {
            int head = random.nextInt(boardSize - 1) + 1;
            if (slSet.contains(head) || head == 1)
                continue;
            int tail = random.nextInt(head) + 1;
            slSet.add(head);
            snakeList.add(new Snake(head, tail));
            totalSnakes--;
        }

        return new Board(boardSize, snakeList, ladderList);
    }
}
