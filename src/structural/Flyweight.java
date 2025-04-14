
/**
 * 🧠 Flyweight Design Pattern
 *
 * 📌 Purpose:
 * The Flyweight pattern reduces memory usage by sharing common parts of objects
 * instead of creating a new object every time. It’s perfect when you have a TON of similar objects.
 *
 * 💡 Real-Life Analogy:
 * Think of a **text editor** 📝: each character on screen is a separate object,
 * but instead of storing font data in every character, it shares a **flyweight** for "font: Arial, size: 12".
 *
 * ✅ Key Features:
 * - Intrinsic state = shared (e.g., font, color)
 * - Extrinsic state = passed in externally (e.g., position)
 * - Useful when creating **lots of small immutable objects**
 */

import java.util.HashMap;


interface Tree {
    void display(int x, int y);  // method declaration must end with ;
}

class TreeType implements Tree {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void display(int x, int y) {
        System.out.println("Displaying " + name + " tree at (" + x + ", " + y + ") with color " + color);
    }
}

class TreeFactory {
    private static final HashMap<String, Tree> treeMap = new HashMap<>();

    public static Tree getTree(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        if (!treeMap.containsKey(key)) {
            treeMap.put(key, new TreeType(name, color, texture));
            System.out.println("Created new TreeType: " + key);
        }
        return treeMap.get(key);
    }
}

public class Flyweight {
    public static void main(String[] args) {
        Tree pine = TreeFactory.getTree("Pine", "Green", "Rough");
        pine.display(10, 20);

        Tree samePine = TreeFactory.getTree("Pine", "Green", "Rough");
        samePine.display(15, 25);

        Tree birch = TreeFactory.getTree("Birch", "White", "Smooth");
        birch.display(30, 40);
    }
}
