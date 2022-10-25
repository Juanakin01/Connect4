class Player {

    private Color color;
    private Board board;

    Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

    public void play() {
        int column;
        Coordinate coordinate = new Coordinate(0,0);
        Error error;
        do {
            coordinate.setCol(Console.getInstance().readInt("Introduce column:"));
            error=this.getPlayError(coordinate);
        }while(!error.isNull());
        board.putToken(coordinate.getPosCol(), this.color);
    }

    private Error getPlayError(Coordinate coordinate) {

        Error error = Error.NULL;
        if (Coordinate.outOfBounds(coordinate)) {
            error = Error.OUT_OF_BOUNDS;
        }
        else if (!this.board.isColumnFree(coordinate.getPosCol())) {
            error = Error.COLUMN_FULL;
        }
        error.writeln();
        return error;
    }
}