package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

public class WallFollowPlayer implements Player {
    @Override
    public Direction nextMove(Labyrinth l) throws InvalidMoveException {
        /*if (l.possibleMoves().contains(Direction.NORTH)) {
            l.movePlayer(Direction.NORTH);
        } else if (l.possibleMoves().contains(Direction.EAST)) {
            l.movePlayer(Direction.EAST);
        } else if (l.possibleMoves().contains(Direction.SOUTH)) {
            l.movePlayer(Direction.SOUTH);
        } else if (l.possibleMoves().contains(Direction.WEST)) {
            l.movePlayer(Direction.WEST);
        }
         */
        if (l.possibleMoves().contains(Direction.WEST) || l.possibleMoves().contains(Direction.EAST)
            || l.possibleMoves().contains(Direction.SOUTH) || l.possibleMoves().contains(Direction.NORTH)) {
            l.movePlayer(Direction.EAST);
        } else {
            l.movePlayer(Direction.valueOf(CellType.EMPTY.name()));
        }
        return Direction.valueOf("");
    }
}
