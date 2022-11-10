package JavaBasic.oodExamples.Compound.Observer;

import designpatterns.ood.Compound.AbstractFactory.AbstractDuckFactory;
import designpatterns.ood.Compound.AbstractFactory.CountingDuckFactory;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();

        duckSimulator.simulate(abstractDuckFactory);
    }

    void simulate(AbstractDuckFactory abstractDuckFactory) {

    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
