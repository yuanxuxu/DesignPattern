package designpatterns.structural.proxy;

/**
 * A proxy, in its most general form, is a class
 * functioning as an interface to something else
 *
 * Use of the proxy can simply be forwarding to the
 * real object, or can provide additional logic
 * */

public class Proxy {

    public static void main(String[] args) {
        Image image = new ProxyImage("file1");
        image.display();

        image.display();
    }

}

// can be class
interface Image {
    public void display();
}

class RealImage implements Image {

    private final String name;

    public RealImage(String name) {
        this.name = name;
        load();
    }

    private void load() {
        System.out.println("Loading " + name);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + name);
    }
}

class ProxyImage implements Image {

    private final String name;
    private RealImage realImage;

    public ProxyImage(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(name);
        }
        realImage.display();
    }
}