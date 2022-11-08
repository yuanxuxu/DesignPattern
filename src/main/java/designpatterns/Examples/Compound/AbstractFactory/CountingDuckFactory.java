package designpatterns.Examples.Compound.AbstractFactory;

import designpatterns.Examples.Compound.DuckCall;
import designpatterns.Examples.Compound.MallardDuck;
import designpatterns.Examples.Compound.Quackable;
import designpatterns.Examples.Compound.RedheadDuck;
import designpatterns.Examples.Compound.RubberDuck;
import designpatterns.Examples.Compound.Decorator.QuackCounterDecorator;

public class CountingDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounterDecorator(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounterDecorator(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounterDecorator(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounterDecorator(new RubberDuck());
    }

}
