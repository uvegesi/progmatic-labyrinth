package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {

    private int width;
    private int height;
    private Coordinate[][] coordinates = new Coordinate[width][height];
    //private CellType[][] types = new CellType[width][height];
    private Coordinate coordinates2;

    public LabyrinthImpl(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public LabyrinthImpl(Coordinate coordinates2) {
        this.coordinates2 = coordinates2;
    }

    public LabyrinthImpl() {

    }

    @Override
    public int getWidth() {
        if (coordinates2.getCol() != 0) {
            return coordinates2.getCol();
        } else {
            return -1;
        }
    }

    @Override
    public int getHeight() {
        if (coordinates2.getRow() != 0) {
            return coordinates2.getRow();
        } else {
            return -1;
        }
    }

    @Override
    public void loadLabyrinthFile(String fileName) throws CellException {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int width = Integer.parseInt(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());
            CellType type;
            for (int hh = 0; hh < height; hh++) {
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    switch (line.charAt(ww)) {
                        case 'W':
                            type = CellType.WALL;
                            break;
                        case 'E':
                            type = CellType.END;
                            break;
                        case 'S':
                            type = CellType.START;
                            break;
                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex.toString());
        }
        setCellType(coordinates[width][height], CellType.START);
        //CellType.START = coordinates[0][0];
    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {
        //Coordinate [][] co = new Coordinate[c.getRow()][c.getCol()];
        if (c.getRow() < 0 || c.getRow() >= coordinates[0].length || c.getCol() < 0 || c.getCol() >= coordinates.length) {
            throw new CellException(c.getRow(), c.getCol(), "Nincs ilyen cella!");
        }
        return CellType.valueOf("");
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {
        if (c.getRow() < 0 || c.getRow() >= coordinates[0].length || c.getCol() < 0 || c.getCol() >= coordinates.length) {
            throw new CellException(c.getRow(), c.getCol(), "Nincs ilyen cella.");
        }
        if (type.equals(CellType.START)) {
            coordinates[c.getRow()][c.getCol()] = CellType.EMPTY;
        }
        coordinates[c.getRow()][c.getCol()] = c.;
    }

    @Override
    public Coordinate getPlayerPosition() {
        return coordinates[width][height];
    }

    @Override
    public boolean hasPlayerFinished() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (coordinates[i][j] = CellType.END) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Direction> possibleMoves() {
        List<Direction> possMoves = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (coordinates[i][j] = CellType.EMPTY) {
                    possMoves.add(Direction.valueOf(""));
                }
            }
        }
        return possMoves;
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {
        if (direction != possibleMoves().get(0)) {
            throw new InvalidMoveException();
        } else {
            coordinates[width][height] = Direction.valueOf("");
        }

    }

}
