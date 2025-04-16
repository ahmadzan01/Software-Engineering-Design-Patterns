/**
 * 🧠 Template Method Design Pattern
 *
 * 📌 Purpose:
 * Defines the **skeleton of an algorithm** in a base class, deferring specific steps to subclasses.
 *
 * 💡 Real-Life Analogy:
 * Making **instant noodles** 🍜:
 * 1. Boil water
 * 2. Add noodles
 * 3. Add toppings (can vary!)
 * 4. Serve
 *
 * ✅ Key Features:
 * - Reuses core logic
 * - Allows subclasses to customize specific parts
 * - Promotes code reuse and consistency
 */

 abstract class NoodleRecipe {
    public final void cook() {
        boilWater();
        addNoodles();
        addToppings();
        serve();
    }

    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void addNoodles() {
        System.out.println("Adding noodles...");
    }

    protected abstract void addToppings(); // Hook

    private void serve() {
        System.out.println("Serving noodles 🍜");
    }
}

class ChickenNoodles extends NoodleRecipe {
    protected void addToppings() {
        System.out.println("Adding chicken and scallions ");
    }
}

class SpicyNoodles extends NoodleRecipe {
    protected void addToppings() {
        System.out.println("Adding chili oil and garlic ");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        NoodleRecipe dish1 = new ChickenNoodles();
        dish1.cook();

        System.out.println();

        NoodleRecipe dish2 = new SpicyNoodles();
        dish2.cook();
    }
}
