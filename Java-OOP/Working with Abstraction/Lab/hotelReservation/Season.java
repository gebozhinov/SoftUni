package workingWithAbstraction.lab.hotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int seasonValue;

    Season(int seasonValue) {
        this.seasonValue = seasonValue;
    }

    public int getSeasonValue() {
        return seasonValue;
    }

    public static Season parse(String str) {
        return Season.valueOf(str.toUpperCase());
    }
}
