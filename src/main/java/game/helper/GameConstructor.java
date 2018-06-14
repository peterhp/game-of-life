package game.helper;

import game.model.Cell;
import game.model.CellWorld;

public final class GameConstructor {

    public CellWorld initWorld(int[][] cellMap) {
        int width = cellMap[0].length;
        int height = cellMap.length;

        CellWorld world = new CellWorld(width, height);

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (cellMap[y][x] == 1) {
                    world.addCell(new Cell(x, y));
                }
            }
        }

        return world;
    }
}
