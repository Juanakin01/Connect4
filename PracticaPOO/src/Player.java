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
        Error error;
        do {
            column = Console.getInstance().readInt("Introduce column:");
            error=this.getPlayError(column);
        }while(!error.isNull());
        board.putToken(column, this.color);
    }

    private Error getPlayError(int column) {

        Error error = Error.NULL;
        if (Coordinate.outOfBounds(column)) {
            error = Error.OUT_OF_BOUNDS;
        }
        else if (!this.board.isColumnFree(column)) {
            error = Error.COLUMN_FULL;
        }
        error.writeln();
        return error;
    }
}