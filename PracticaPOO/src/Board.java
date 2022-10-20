class Board {

    private Color[][] colors;
    public Board() {
        this.colors = new Color[Coordinate.ROWS][Coordinate.COLS];
        this.reset();
    }

    private void reset() {
        for (int i = 0; i < Coordinate.ROWS; i++) {
            for (int j = 0; j < Coordinate.COLS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }


    /*public void putToken(int column, Color color) {
        int avaliableRow=0;
        while (!this.colors[avaliableRow][column].isNull()){
            avaliableRow++;
        }
        this.colors[avaliableRow][column] = color;
        this.showBoard();
    }*/

    private void setColors(Coordinate coordinate,Color color) {
        this.colors[coordinate.getPosRow()][coordinate.getPosCol()]=color;
    }

    public void putToken(int column, Color color) {
        Coordinate coordinate=new Coordinate(0,column);
        while (positionFull(coordinate)){
            coordinate.setRow(coordinate.getPosRow()+1);
        }
        setColors(coordinate,color);
        this.showBoard();
    }

    private boolean positionFull(Coordinate coordinate){
        return colors[coordinate.getPosRow()][coordinate.getPosCol()]!=Color.NULL;
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

    public boolean isColumnFree(int column){
        return this.colors[Coordinate.ROWS-1][column].isNull();
    }

    public boolean isFull() {
        int acumColumn = 0;
        for(int i=0; i<Coordinate.COLS; i++){
            if(!isColumnFree(i)){
                acumColumn += 1;
            }
        }
        return acumColumn == Coordinate.COLS;
    };

}