enum Error {
    COLUMN_FULL("The column is full, choose another one"),
    OUT_OF_BOUNDS("The column is out of bounds, choose another one"),
    NULL;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    void writeln() {
        if (!this.isNull()) {
            Console.getInstance().writeln(this.message);
        }
    }

    public boolean isNull() {
        return this == Error.NULL;
    }

}