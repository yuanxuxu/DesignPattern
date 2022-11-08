package designpatterns.behavioral.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        System.out.println("Hello Design Patterns");
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        light.off();
        Command command = new LightOnCommand(light);
        simpleRemoteControl.setCommand(command);
        simpleRemoteControl.buttonWasPressed();
        // System.out.println("Hello Design Patterns");
    }
}

interface Command {
    public void execute();
}

class Light {
    public void on() {
        System.out.println("Light on.");
    }

    public void off() {
        System.out.println("Light off");
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}