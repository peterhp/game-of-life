package game.helper;

import game.model.Cell;
import game.model.CellWorld;
import game.model.Position;

public class GameRenderer {

    private static final String RUNE_CELL = "*";
    private static final String RUNE_EMPTY = " ";

    public void render(CellWorld world) {
        int[][] cellMap = convert(world);

        for (int y = 0; y < cellMap.length; ++y) {
            for (int x = 0; x < cellMap[0].length; ++x) {
                String rune = cellMap[y][x] == 1 ? RUNE_CELL : RUNE_EMPTY;
                System.out.print(rune);
            }
            System.out.println();
        }
    }

    public int[][] convert(CellWorld world) {
        int width = world.getWidth();
        int height = world.getHeight();

        int[][] cellMap = new int[height][width];
        for (Cell cell : world.getCells()) {
            Position pos = cell.getPosition();
            cellMap[pos.y][pos.x] = 1;
        }

        return cellMap;
    }
}
