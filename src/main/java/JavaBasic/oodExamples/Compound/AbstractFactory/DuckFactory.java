package JavaBasic.oodExamples.Compound.AbstractFactory;

import designpatterns.ood.Compound.DuckCall;
import designpatterns.ood.Compound.MallardDuck;
import designpatterns.ood.Compound.Quackable;
import designpatterns.ood.Compound.RedheadDuck;
import designpatterns.ood.Compound.RubberDuck;

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
