package designpatterns.behavioral.strategy;

import com.google.common.collect.Lists;

import java.util.List;

public class StrategyDemo {
    public static void main(String[] args) {
        BillingStrategy normal = BillingStrategy.normalStrategy();
        BillingStrategy happy = BillingStrategy.happyHourStrategy();

        Customer first = new Customer(normal);
        first.add(100, 1);

        first.setStrategy(happy);
        first.add(100, 2);

        Customer second = new Customer(happy);
        second.add(80, 1);

        first.printBill();

        second.setStrategy(normal);
        second.add(130, 2);
        second.add(250, 1);

        second.printBill();
    }
}

interface BillingStrategy {
    int getActPrice(int rawPrice);

    static BillingStrategy normalStrategy() {
        return rawPrice -> rawPrice;
    }

    static BillingStrategy happyHourStrategy() {
        return rawPrice -> rawPrice / 2;
    }
}

class Customer {
    private final List<Integer> drinks = Lists.newArrayList();
    private BillingStrategy strategy;

    public Customer(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(int price, int quantity) {
        this.drinks.add(this.strategy.getActPrice(price * quantity));
    }

    public void printBill() {
        int sum = this.drinks.stream().mapToInt(v -> v).sum();
        System.out.println("Total due: " + sum);
        this.drinks.clear();
    }

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }
}























