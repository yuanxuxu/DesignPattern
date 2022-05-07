package designpatterns.behavioral.command;

import java.util.HashMap;

/**
 * 行为型模式(Behavioral Pattern)是对在不同的对象之间划分责任和算法的抽象化
 *
 * 命令模式: 将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化；
 * 对请求排队或者记录请求日志，以及支持可撤销的操作
 *
 * In object-oriented programming, the command pattern is a
 * behavioral design pattern in which an object is used to
 * encapsulate all information needed to perform an action
 * or trigger an event at a later time. This information
 * includes the method name, the object that owns the method
 * and values for the method parameters.
 * 
 * The Command Pattern encapsulates a request as an object, thereby letting you
 * parameterize other objects with different requests, queue or log requests,
 * and support undoable operations.
 *
 */
public class CommandExample {

    public static void main(String[] args) {
        // Receiver
        Light lamp = new Light();

        // ConcreteCommand
        Command switchOn = new SwitchOnCommand(lamp);
        Command switchOff = new SwitchOffCommand(lamp);

        // Invoker
        Switch mySwitch = new Switch();
        mySwitch.register("on", switchOn);
        mySwitch.register("off", switchOff);

        mySwitch.execute("on");
        mySwitch.execute("off");
    }

}

/** The Command interface */
interface Command {
    void execute();
}

/** The Invoker class */
class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalArgumentException("no command registered for " +
                    commandName);
        }
        command.execute();
    }
}

/** The Receiver class */
class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }

    public void turnOff() {
        System.out.println("The light is off");
    }
}

/** ConcreteCommand */
class SwitchOnCommand implements Command {
    private final Light light;

    public SwitchOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class SwitchOffCommand implements Command {
    private final Light light;

    public SwitchOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
