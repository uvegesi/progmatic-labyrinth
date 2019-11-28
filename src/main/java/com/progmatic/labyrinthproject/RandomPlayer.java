package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

public class RandomPlayer implements Player {

    @Override
    public Direction nextMove(Labyrinth l) throws InvalidMoveException {
        if (!l.hasPlayerFinished()) {
            double rand = Math.random();
            if (rand < .25) {
                l.movePlayer(Direction.EAST);
            } else if (rand < .50) {
                l.movePlayer(Direction.NORTH);
            } else if (rand < .75) {
                l.movePlayer(Direction.SOUTH);
            } else {
                l.movePlayer(Direction.WEST);
            }
        }
        return Direction.valueOf("");
    }
}
