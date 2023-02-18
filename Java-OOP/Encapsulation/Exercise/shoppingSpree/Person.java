package encapsulation.exercises.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - ", name));
        if (!products.isEmpty()) {
            sb.append(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        } else {
            sb.append("Nothing bought");
        }
        return sb.toString();
    }
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()) {
            products.add(product);
            money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", name , product.getName()));
        }
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
