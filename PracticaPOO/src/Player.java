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
        int column = Console.getInstance().readInt("Introduce column:");
        board.putToken(column, this.color);
    }
}