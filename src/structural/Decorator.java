/**
 * 🧠 Decorator Design Pattern
 *
 * 📌 Purpose:
 * The Decorator pattern lets you dynamically attach new behavior to objects 
 * without modifying their structure. It’s a flexible alternative to subclassing.
 *
 * 💡 Real-Life Analogy:
 * Think of a **coffee shop** ☕. You order a base coffee, then add toppings:
 * whipped cream, caramel drizzle, etc. — you’re decorating the coffee 🎨.
 *
 * ✅ Key Features:
 * - Wraps objects with other objects
 * - Each wrapper adds new behavior
 * - Promotes open/closed principle (open for extension, closed for modification)
 */

// 🧱 Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// 🍵 Concrete Component
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }

    public double getCost() {
        return 2.0;
    }
}

// 🎁 Decorator Base Class
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

// 🧁 Concrete Decorators
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

// 👤 Client code
public class Decorator {
    public static void main(String[] args) {
        Coffee myOrder = new BasicCoffee();
        myOrder = new MilkDecorator(myOrder);
        myOrder = new WhipDecorator(myOrder);

        System.out.println("Order: " + myOrder.getDescription());
        System.out.println("Total: $" + myOrder.getCost());
    }
}

