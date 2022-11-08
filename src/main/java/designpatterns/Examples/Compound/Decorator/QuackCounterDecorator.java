package designpatterns.Examples.Compound.Decorator;

import designpatterns.Examples.Compound.Quackable;

public class QuackCounterDecorator implements Quackable {
    Quackable duck;
    private static int numberOfQuacks = 0;

    public QuackCounterDecorator(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }

}
