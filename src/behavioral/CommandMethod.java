/**
 * 🧠 Command Design Pattern
 *
 * 📌 Purpose:
 * The Command pattern turns a request (like "turn on light") into an object,
 * so you can pass it, store it, queue it, or undo it later.
 *
 * 💡 Real-Life Analogy:
 * Think of a **TV remote** 📺. Each button is a command: "Volume Up", "Mute", "Power Off".
 * Pressing a button sends a command to the TV — but the remote doesn’t need to know how it works internally.
 *
 * ✅ Key Features:
 * - Encapsulates actions as objects
 * - Allows undo/redo, queuing, logging commands
 * - Decouples sender from receiver
 */

// Command interface
interface Command {
    void execute();
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON 💡");
    }

    public void turnOff() {
        System.out.println("Light is OFF 🌑");
    }
}

// Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client
public class CommandMethod {
    public static void main(String[] args) {
        Light light = new Light();

        Command lightsOn = new LightOnCommand(light);
        Command lightsOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightsOn);
        remote.pressButton();

        remote.setCommand(lightsOff);
        remote.pressButton();
    }
}
