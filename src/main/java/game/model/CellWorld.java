package game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CellWorld {

    private int width;
    private int height;

    private Map<Position, Cell> cells = new HashMap<>();

    public CellWorld(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addCell(Cell cell) {
        Position pos = cell.getPosition();
        if ((pos.x >= 0 && pos.x < width)
                && (pos.y >= 0 && pos.y < height)) {
            cells.put(pos, cell);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cells.values());
    }

    public void evolve() {
        Map<Position, Cell> newCells = new HashMap<>();

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                Position curPos = new Position(x, y);

                int neighbors = countNeighbors(curPos);
                Cell cell = cellEvolve(curPos, neighbors);

                if (cell != null) {
                    newCells.put(curPos, cell);
                }
            }
        }

        cells = newCells;
    }

    private int countNeighbors(Position pos) {
        int count = 0;
        for (int xOffset = -1; xOffset <= 1; ++xOffset) {
            for (int yOffset = -1; yOffset <= 1; ++yOffset) {
                if (cells.containsKey(new Position(pos.x + xOffset, pos.y + yOffset))) {
                    count++;
                }
            }
        }

        return count - (cells.containsKey(pos) ? 1 : 0);
    }

    private Cell cellEvolve(Position pos, int neighbors) {
        if (neighbors == 3) {
            return cells.containsKey(pos) ? cells.get(pos) : new Cell(pos);
        }

        if (neighbors == 2 && cells.containsKey(pos)) {
            return cells.get(pos);
        }

        return null;
    }
}
