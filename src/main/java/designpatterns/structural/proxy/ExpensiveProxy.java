package designpatterns.structural.proxy;

public class ExpensiveProxy {
    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectImpl();
        object.process();
        object.process();
    }
}

interface ExpensiveObject {
    void process();
}

class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        System.out.println("heavyInitialConfiguration");
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub
        System.out.println("processing complete.");
    }

}

class ExpensiveObjectProxy implements ExpensiveObject {
    private static ExpensiveObject object;

    @Override
    public void process() {
        // TODO Auto-generated method stub
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }

}