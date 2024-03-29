package JavaBasic.ood.Compound.Composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import JavaBasic.ood.Compound.Quackable;

// composite needs to implement the same interface as leaf elements
public class Flock implements Quackable {

    List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }

}
