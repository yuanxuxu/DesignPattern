package designpatterns.Examples.Compound.AbstractFactory;

import designpatterns.Examples.Compound.Quackable;

public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedHeadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}
