package game;

import game.helper.GameConstructor;
import game.helper.GameRenderer;
import game.model.CellWorld;

public class GameLauncher {

    public static void main(String[] args) {
        System.out.println("Welcome to Cell World!");

        GameConstructor constructor = new GameConstructor();
        GameRenderer renderer = new GameRenderer();

        int[][] initCellMap = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        CellWorld world = constructor.initWorld(initCellMap);

        for (int generation = 1; generation <= 5; ++generation) {
            System.out.println("Cell World -- " + generation);
            renderer.render(world);

            world.evolve();
        }
    }
}
