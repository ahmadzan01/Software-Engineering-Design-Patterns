/**
 * 🧠 Chain of Responsibility Design Pattern
 *
 * 📌 Purpose:
 * This pattern lets you pass a request through a chain of handlers.
 * Each handler decides to either handle the request or pass it to the next one.
 *
 * 💡 Real-Life Analogy:
 * Think of **technical support tiers** 🧑‍💻:
 * Level 1 support → Level 2 → Level 3 → ...  
 * If Level 1 can’t solve it, they escalate it to the next level.
 *
 * ✅ Key Features:
 * - Decouples sender from receiver
 * - Adds flexibility in request processing
 * - Handlers are chained together
 */

// Handler interface
abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}

// Concrete handlers
class LowLevelSupport extends Handler {
    public void handleRequest(String request) {
        if (request.equals("password reset")) {
            System.out.println("Low-level support handled: " + request);
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

class MidLevelSupport extends Handler {
    public void handleRequest(String request) {
        if (request.equals("software install")) {
            System.out.println("Mid-level support handled: " + request);
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

class HighLevelSupport extends Handler {
    public void handleRequest(String request) {
        if (request.equals("server crash")) {
            System.out.println("High-level support handled: " + request);
        } else {
            System.out.println("Request unhandled: " + request);
        }
    }
}

// Client
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler low = new LowLevelSupport();
        Handler mid = new MidLevelSupport();
        Handler high = new HighLevelSupport();

        low.setNext(mid);
        mid.setNext(high);

        low.handleRequest("password reset");
        low.handleRequest("software install");
        low.handleRequest("server crash");
        low.handleRequest("alien invasion");
    }
}
