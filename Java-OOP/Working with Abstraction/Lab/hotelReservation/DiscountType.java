package workingWithAbstraction.lab.hotelReservation;

public enum DiscountType {
    VIP(0.80), SECOND_VISIT(0.90), NONE(1);

    private double priceReduction;

    DiscountType(double priceReduction) {
        this.priceReduction = priceReduction;
    }

    public double getPriceReduction() {
        return priceReduction;
    }

    public static DiscountType parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Invalid parse command " + str);
        }
    }
}
