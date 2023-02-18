package workingWithAbstraction.exercise.greedyTimes;

public class Item {
    private String item;

    public Item(String item) {
        this.item = item;

    }

    public String getItem() {
        String item = "";
        if (this.item.length() == 3) {
            item = "Cash";
        } else if (this.item.toLowerCase().endsWith("gem")) {
            item = "Gem";
        } else if (this.item.equalsIgnoreCase("gold")) {
            item = "Gold";
        }
        return item;
    }


}
