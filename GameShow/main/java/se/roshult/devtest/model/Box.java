package se.roshult.devtest.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Box {
    Prize prize;
    boolean isPicked = false;
}
