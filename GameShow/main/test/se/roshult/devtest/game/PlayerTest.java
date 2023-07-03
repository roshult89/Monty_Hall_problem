package se.roshult.devtest.game;

import org.junit.jupiter.api.Test;
import se.roshult.devtest.model.Box;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    Player player = new Player();

    @Test
    void shouldPickADoor(){
        //Given
        List<Box> boxes = List.of(Box.builder().build(),
                Box.builder().build(),
                Box.builder().build());
        //When
        player.pickBox(boxes);
        //Then
        assertTrue(boxes.stream().anyMatch(Box::isPicked));
    }

}
