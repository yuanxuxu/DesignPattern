package JavaBasic.oodExamples.Compound.AbstractFactory;

import designpatterns.ood.Compound.DuckCall;
import designpatterns.ood.Compound.MallardDuck;
import designpatterns.ood.Compound.Quackable;
import designpatterns.ood.Compound.RedheadDuck;
import designpatterns.ood.Compound.RubberDuck;
import designpatterns.ood.Compound.Decorator.QuackCounterDecorator;

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
