package inheritance.lab.randomArrayList;

public class Main {
    public static void main(String[] args) {


        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add("5");
        randomArrayList.add("6");
        randomArrayList.add("7");
        randomArrayList.add("8");

        System.out.println(randomArrayList.getRandomElement());
    }
}
