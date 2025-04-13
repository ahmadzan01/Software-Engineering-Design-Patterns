/**
 * 🧠 Singleton Design Pattern
 *
 * 📌 Purpose:
 * The Singleton pattern ensures that a class has only ONE instance
 * in the entire program and provides a global point of access to it.
 *
 * 💡 Real-Life Analogy:
 * Think of it like the **President of a country** — 
 * there's only one, and everyone refers to the same person globally.
 * If someone tries to "create" another president — the system says "nope, use the one we already have."
 *
 * ✅ Key Features:
 * - Private constructor (so no one can create a new instance directly)
 * - Static instance stored inside the class
 * - Public method to access that single instance
 */


 public class Singleton {
    
    // Step 1: Private static variable to hold the one instance
    private static Singleton instance;

    // Step 2: Private constructor (prevents direct instantiation)
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Step 3: Public method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // Lazy initialization
        }
        return instance;
    }

    // Demo method
    public void sayHello() {
        System.out.println("Hello from the Singleton!");
    }

    // Test the Singleton
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("Are both instances the same? " + (s1 == s2));  // should be true
        s1.sayHello();
    }
}