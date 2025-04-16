/**
 * 🧪 TestAllPatterns.java
 *
 * Demoing:
 * - Singleton (Creational)
 * - Decorator (Structural)
 * - Command (Behavioral)
 */
public class TestAllPatterns {
    public static void main(String[] args) {
        // === CREATIONAL: Singleton ===
        System.out.println("==== CREATIONAL: Singleton ====");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Are s1 and s2 the same? " + (s1 == s2));
        s1.sayHello();

        // === STRUCTURAL: Decorator ===
        System.out.println("\n==== STRUCTURAL: Decorator ====");
        Coffee myCoffee = new BasicCoffee();
        myCoffee = new MilkDecorator(myCoffee);
        myCoffee = new WhipDecorator(myCoffee);
        System.out.println("Order: " + myCoffee.getDescription());
        System.out.println("Cost: $" + myCoffee.getCost());

        // === BEHAVIORAL: Command ===
        System.out.println("\n==== BEHAVIORAL: Command ====");
        Light light = new Light();
        Command turnOn = new LightOnCommand(light);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOn);
        remote.pressButton();
    }
}

// ================== Singleton ==================
class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello from Singleton!");
    }
}

// ================== Decorator ==================
interface Coffee {
    String getDescription();
    double getCost();
}

class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }

    public double getCost() {
        return 2.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee c) {
        this.decoratedCoffee = c;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee c) {
        super(c);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }
}

class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee c) {
        super(c);
    }

    public String getDescription() {
        return super.getDescription() + ", Whip";
    }

    public double getCost() {
        return super.getCost() + 0.7;
    }
}

// ================== Command ==================
interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light is ON 💡");
    }

    public void turnOff() {
        System.out.println("Light is OFF 🌑");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
