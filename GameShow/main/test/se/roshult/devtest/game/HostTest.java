package se.roshult.devtest.game;

import org.junit.jupiter.api.Test;
import se.roshult.devtest.model.Box;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static se.roshult.devtest.model.Prize.MONEY;
import static se.roshult.devtest.model.Prize.NOTHING;

class HostTest {

    Host host = new Host();

    @Test
    void shouldPickUnpickedAndEmptyBox(){
        //Given
        List<Box> boxes= List.of(
                Box.builder().prize(MONEY).build(),
                Box.builder().prize(NOTHING).isPicked(true).build(),
                Box.builder().prize(NOTHING).build());
        //When
        host.pickBox(boxes);
        //Then the last one is pickes (since it's the only unpicked and without a prize)
        assertTrue(boxes.get(2).isPicked());
    }

}
