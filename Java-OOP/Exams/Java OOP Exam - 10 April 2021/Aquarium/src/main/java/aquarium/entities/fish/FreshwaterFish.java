package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{

    private static final int SIZE = 3;

    public FreshwaterFish(String name, String spices, double price) {
        super(name, spices, price);
        super.setSize(SIZE);

    }

    @Override
    public void eat() {
        super.setSize(getSize() + 3);
    }
}
