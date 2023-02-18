package workingWithAbstraction.exercise.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private Map<String, LinkedHashMap<String, Long>> bag;
    private Item item;

    public Bag() {
        this.bag = new LinkedHashMap<>();
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public String getItem() {
        return this.item.getItem();
    }

    public void putItem(String name, long amount) {
        if (!this.bag.containsKey(this.item.getItem())) {
            this.bag.put(this.item.getItem(), new LinkedHashMap<>());
        }

        if (!this.bag.get(this.item.getItem()).containsKey(name)) {
            this.bag.get(this.item.getItem()).put(name, 0L);
        }


        this.bag.get(this.item.getItem()).put(name, this.bag.get(this.item.getItem()).get(name) + amount);
    }

    public boolean isRuleKept(String item, long amount) {
        // The rules are:
        //•	The gold amount in your bag should always be more than or equal to the gem amount at any time
        //•	The gem amount should always be more than or equal to the cash amount at any time
        if (!this.bag.containsKey(this.item.getItem())) {
            if (this.bag.containsKey(item)) {
                return amount > this.bag.get("Gold").values()
                        .stream().mapToLong(e -> e).sum();
            } else {
                return true;
            }
        } else
            return this.bag.get(this.item.getItem()).values().stream()
                    .mapToLong(e -> e).sum() + amount > this.bag.get(item)
                    .values().stream().mapToLong(e -> e).sum();
    }

    public void printResult() {
        for (var currentItem : this.bag.entrySet()) {
            Long sumValues = currentItem.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", currentItem.getKey(), sumValues);

            currentItem.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    public boolean isFull(long input, long amount) {
        return input < this.bag.values().stream().map(Map::values)
                .flatMap(Collection::stream).mapToLong(e -> e).sum() + amount;
    }
}
