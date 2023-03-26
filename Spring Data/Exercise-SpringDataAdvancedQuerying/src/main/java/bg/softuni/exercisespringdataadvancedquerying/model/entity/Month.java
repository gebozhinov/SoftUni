package bg.softuni.exercisespringdataadvancedquerying.model.entity;

public enum Month {
    JAN, FEB, MARCH, APRIL, MAY, JUNE, JULY, AUG, SEPT, OCT, NOV, DEC;

    public int getValue() {
        return ordinal() + 1;
    }

}
