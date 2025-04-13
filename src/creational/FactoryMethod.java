/**
 * 🧠 Factory Method Design Pattern
 *
 * 📌 Purpose:
 * The Factory Method pattern is used to **create objects without specifying the exact class**.
 * Instead of using `new SomeClass()`, we use a "factory" method to handle the object creation.
 *
 * 💡 Real-Life Analogy:
 * Think of a **pizza store** 🍕. You don’t make the pizza yourself — you just ask for a "Pepperoni" or "Veggie",
 * and the store (factory) knows how to make it. You don’t need to know *how* it's made.
 *
 * ✅ Key Features:
 * - A superclass defines a factory method
 * - Subclasses override it to specify which class to instantiate
 * - Promotes flexibility and abstraction in object creation
 */

// Product interface

interface Pizza {
    void prepare();
}

// Concrete Products
class PepperoniPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza 🍕");
    }
}

class VeggiePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Veggie Pizza 🥦🍅");
    }
}

// Factory (Creator)
abstract class PizzaStore {
    public void orderPizza() {
        Pizza pizza = createPizza();
        pizza.prepare();
    }

    // Factory Method — subclasses decide which Pizza to create
    protected abstract Pizza createPizza();
}

// Concrete Creators
class PepperoniPizzaStore extends PizzaStore {
    protected Pizza createPizza() {
        return new PepperoniPizza();
    }
}

class VeggiePizzaStore extends PizzaStore {
    protected Pizza createPizza() {
        return new VeggiePizza();
    }
}

// Test the Factory Method
public class FactoryMethod {
    public static void main(String[] args) {
        PizzaStore pepperoniStore = new PepperoniPizzaStore();
        pepperoniStore.orderPizza();

        PizzaStore veggieStore = new VeggiePizzaStore();
        veggieStore.orderPizza();
    }
}
