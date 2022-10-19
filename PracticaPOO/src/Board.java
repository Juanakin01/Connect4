class Board {

    private Color[][] colors;
    public Board() {
        this.colors = new Color[Coordinate.ROWS][Coordinate.COLS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.ROWS; i++) {
            for (int j = 0; j < Coordinate.COLS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }
//While o for?
    public void putToken(int column, Color color) {
        boolean placed = false;
        if (this.colors[Coordinate.ROWS - 1][column].isNull()) {
            for (int i = 0; i <= Coordinate.ROWS - 1; i++) {
                if (!placed && this.colors[i][column].isNull()) {
                    this.colors[i][column] = color;
                    placed = true;
                }
            }
        } else {
            //ERROR
        }
        this.showBoard();
    }

    public void showBoard() {
        for (int i = Coordinate.ROWS-1; i >= 0; i--) {
            for (int j = 0; j < Coordinate.COLS; j++) {
                if (this.colors[i][j].isNull()) {
                    System.out.print("|\t \t");
                } else {
                    System.out.print("|\t" + this.colors[i][j] + "\t");
                }
            }
            System.out.print("|\n");
        }
        System.out.println();
    }
//NUEVO
    public boolean isFull() {
        int acumColumn = 0;
        for(int i=0; i<Coordinate.COLS-1; i++){
            if(!this.colors[Coordinate.ROWS-1][i].isNull()){
                acumColumn += 1;
            }
        }
        return acumColumn == Coordinate.COLS-1;
    };

}