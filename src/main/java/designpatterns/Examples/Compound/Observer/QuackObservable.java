package designpatterns.Examples.Compound.Observer;

public interface QuackObservable {
    public void registerObserver(Observer observer);

    public void notifyObservers();
}
