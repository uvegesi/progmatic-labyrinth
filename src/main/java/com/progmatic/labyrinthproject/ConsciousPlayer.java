package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

public class ConsciousPlayer implements Player {
    @Override
    public Direction nextMove(Labyrinth l) throws InvalidMoveException {
        return null;
    }
}
