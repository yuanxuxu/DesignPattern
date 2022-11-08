package designpatterns.Examples.Compound.AbstractFactory;

import designpatterns.Examples.Compound.DuckCall;
import designpatterns.Examples.Compound.MallardDuck;
import designpatterns.Examples.Compound.Quackable;
import designpatterns.Examples.Compound.RedheadDuck;
import designpatterns.Examples.Compound.RubberDuck;

public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

}
