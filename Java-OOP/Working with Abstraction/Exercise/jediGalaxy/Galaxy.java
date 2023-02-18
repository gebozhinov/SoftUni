package workingWithAbstraction.exercise.jediGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }
    public long moveJedi(long collectedStars, int jediRow, int jediCol) {
        while (jediRow >= 0 && jediCol < this.field.getColLength()) {
            if (this.field.isInBounds(jediRow, jediCol)) {
                collectedStars += this.field.getValue(jediRow, jediCol);
            }

            jediCol++;
            jediRow--;
        }
        return collectedStars;
    }

    public void moveEvil(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (this.field.isInBounds(evilRow, evilCol)) {
                this.field.setValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }
}
