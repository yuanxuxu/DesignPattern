package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The observer pattern is a software design pattern in which an object,
 * called the subject, maintains a list of its dependents, called observers,
 * and notifies them automatically of any state changes, usually by calling
 * one of their methods.
 *
 * It is mainly used to implement distributed event handling systems,
 * in "event driven" software.
 *
 * This pattern then perfectly suits any process where data arrives through I/O,
 * that is, where data is not available to the CPU at startup, but can arrive
 * "randomly" (HTTP requests, GPIO data, user input from keyboard/mouse/...,
 * distributed databases and blockchains, ...). Most modern languages have built-in
 * "event" constructs which implement the observer pattern components.
 *
 * While not mandatory most 'observers' implementations will use background threads
 * listening for subject events and other support mechanism from the kernel (Linux epoll, ...)
 *
 * */

public class Demo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexObserver(subject);
        new OctObserver(subject);

        System.out.print("\nEnter a number: \n");
        subject.scanSystemIn();
    }

}

abstract class Observer {
    // optional, can be replaced by subject.add(new HexObserver())
    protected Subject subject;
    public abstract void update();
}

class HexObserver extends Observer {
    @Override
    public void update() {
        System.out.println("Hex: " + Integer.toHexString(subject.getState()));
    }

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }
}

class OctObserver extends Observer {

    public OctObserver(Subject subject){
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("Oct: " + Integer.toOctalString(subject.getState()));
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void add(Observer o) {
        observers.add(o);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        execute();
    }

    private void execute() {
        observers.forEach(observer -> observer.update());
    }

    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            setState(Integer.valueOf(line));
        }
    }
}

