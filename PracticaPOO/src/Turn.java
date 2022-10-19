class Turn {

    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    public void reset() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    public void play(){
        this.players[this.activePlayer].play();
        this.activePlayer = (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
    }

    public Color getActiveColor(){
        return this.players[this.activePlayer].getColor();
    };



}