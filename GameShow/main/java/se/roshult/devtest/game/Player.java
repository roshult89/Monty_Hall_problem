package se.roshult.devtest.game;

import se.roshult.devtest.model.Box;

import java.util.List;
import java.util.Random;

public class Player {
    public Box pickBox(List<Box> boxes) {
        Random rand = new Random();
        Box box = boxes.get(rand.nextInt(boxes.size()));
        box.setPicked(true);
        return box;
    }
}
