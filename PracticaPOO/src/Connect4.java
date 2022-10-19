public class Connect4 {

    private Board board= new Board();
    private Turn turn= new Turn(this.board);

    private void play(){

            this.playGame();
    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.showBoard();
        do {
            this.turn.play();
            Message.HORIZONTAL_LINE.writeln();
        } while (!board.isFull());
    }


    public static  void main(String[] args){
        new Connect4().play();
    }
}
