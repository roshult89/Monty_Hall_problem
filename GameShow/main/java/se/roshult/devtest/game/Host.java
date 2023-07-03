package se.roshult.devtest.game;

import se.roshult.devtest.model.Box;

import java.util.List;
import java.util.Random;

import static se.roshult.devtest.model.Prize.MONEY;

public class Host {
    public void pickBox(List<Box> boxes) {
        Box box = chooseABox(boxes);
        while (boxIsAlreadyPickedOrConatinsMoney(box)){
            box = chooseABox(boxes);
        }
        box.setPicked(true);
    }

    private boolean boxIsAlreadyPickedOrConatinsMoney(Box box) {
        return MONEY.equals(box.getPrize()) || box.isPicked();
    }

    private Box chooseABox(List<Box> boxes) {
        Random rand = new Random();
        return boxes.get(rand.nextInt(boxes.size()));
    }
}
