package workingWithAbstraction.exercise.jediGalaxy;

public class Field {
    private int[][] field;

    public Field(int rows, int cols) {
        this.field = new int[rows][cols];
        fillTheGalaxy(rows, cols);
    }

    public void fillTheGalaxy(int rows, int cols) {
        int stars = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.field[i][j] = stars++;
            }
        }
    }
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < this.field.length && col >= 0 && col < this.field[0].length;
    }
    public int getRowLength() {
        return this.field.length;
    }
    public int getColLength() {
        return this.field[0].length;
    }
    public int getValue(int row, int col) {
        return this.field[row][col];
    }
    public void setValue(int row, int col, int newValue) {
        this.field[row][col] = newValue;
    }
}
