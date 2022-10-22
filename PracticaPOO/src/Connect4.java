public class Connect4 {

    private Board board= new Board();
    private Turn turn= new Turn(this.board);

    private void play(){
        do{
            this.playGame();
        }while(this.isResumedGame());

    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.showBoard();
        do {
            this.turn.play();
            Message.HORIZONTAL_LINE.writeln();
        } while (!board.isFull());
    }

    private boolean isResumedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.CONTINUE.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static  void main(String[] args){
        new Connect4().play();
    }
}
