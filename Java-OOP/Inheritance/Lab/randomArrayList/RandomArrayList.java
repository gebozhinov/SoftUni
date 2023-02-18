package inheritance.lab.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElement() {
        Random random = new Random();
        return remove(random.nextInt(size()));
    }
}
