package se.roshult.devtest.game;

import se.roshult.devtest.model.Box;
import se.roshult.devtest.model.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static se.roshult.devtest.model.Prize.MONEY;
import static se.roshult.devtest.model.Prize.NOTHING;
import static se.roshult.devtest.model.Result.LOSS;
import static se.roshult.devtest.model.Result.WIN;

public class Game {

    List<Box> boxes;
    Player player;
    Host host;
    public Game(){
        boxes = new ArrayList<>();
        boxes.add(Box.builder().prize(MONEY).build());
        boxes.add(Box.builder().prize(NOTHING).build());
        boxes.add(Box.builder().prize(NOTHING).build());
        Collections.shuffle(boxes);
        player = new Player();
        host = new Host();
    }
    public Result start(boolean changeBox) {
        Box pickedByPlayer = player.pickBox(boxes);
        host.pickBox(boxes);
        if (!changeBox){
            return getResult(pickedByPlayer);
        }
        Box lastUnpickedBox = getUnpickedBox(boxes);
        return getResult(lastUnpickedBox);
    }

    private Result getResult(Box box) {
        return box.getPrize().equals(MONEY) ? WIN : LOSS;
    }

    private Box getUnpickedBox(List<Box> boxes) {
        return boxes.stream().filter(box -> !box.isPicked()).findFirst().get();
    }
}
