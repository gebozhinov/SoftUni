package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{

    private static final int SIZE = 5;

    public SaltwaterFish(String name, String spices, double price) {
        super(name, spices, price);
        super.setSize(SIZE);
    }

    @Override
    public void eat() {
        super.setSize(getSize() + 2);
    }
}
