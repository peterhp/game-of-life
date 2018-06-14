package game.model;

public final class Cell {

    private final Position position;

    public Cell(int x, int y) {
        this.position = new Position(x, y);
    }

    public Cell(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
