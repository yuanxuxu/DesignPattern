package designpatterns.behavioral.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        System.out.println("Hello Design Patterns");
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light2 light = new Light2();
        light.off();
        Command2 command = new LightOnCommand(light);
        // simpleRemoteControl.setCommand(command);
        // simpleRemoteControl.buttonWasPressed();
        // System.out.println("Hello Design Patterns");
    }
}

 interface Command2 {
    public void execute();
}

class Light2 {
    public void on() {
        System.out.println("Light on.");
    }

    public void off() {
        System.out.println("Light off");
    }
}

class LightOnCommand implements Command2 {
    Light2 light;

    public LightOnCommand(Light2 light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class SimpleRemoteControl {
    Command2 slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command2 command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}