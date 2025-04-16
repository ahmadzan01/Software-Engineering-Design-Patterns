/**
 * 🧠 Visitor Design Pattern
 *
 * 📌 Purpose:
 * Lets you define new operations on objects **without changing their classes**.
 * You define the operation separately, and it gets passed into the objects.
 *
 * 💡 Real-Life Analogy:
 * Think of a **tax auditor** visiting different types of businesses.
 * The businesses don't change, but the auditor applies different rules to each one.
 *
 * ✅ Key Features:
 * - Separate operation logic from the object structure
 * - Allows adding new behaviors without modifying existing classes
 */

// Element interface
interface Shape {
    void accept(Visitor visitor);
}

// Concrete elements
class Circle implements Shape {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Square implements Shape {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor interface
interface Visitor {
    void visit(Circle circle);
    void visit(Square square);
}

// Concrete visitor
class AreaCalculator implements Visitor {
    public void visit(Circle circle) {
        System.out.println("Calculating area of Circle ");
    }

    public void visit(Square square) {
        System.out.println("Calculating area of Square ");
    }
}

// Client
public class VisitorPattern {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(), new Square() };
        Visitor visitor = new AreaCalculator();

        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}
