/**
 * 🧠 Observer Design Pattern
 *
 * 📌 Purpose:
 * Lets one object (subject) notify many other objects (observers) automatically
 * when its state changes.
 *
 * 💡 Real-Life Analogy:
 * Think of **YouTube notifications** 🔔: when a channel uploads a new video,
 * all subscribers are notified.
 *
 * ✅ Key Features:
 * - One-to-many relationship
 * - Observers subscribe/unsubscribe to the subject
 * - Subject broadcasts updates
 */

 import java.util.*;

 interface Observer {
     void update(String message);
 }
 
 interface Subject {
     void subscribe(Observer o);
     void unsubscribe(Observer o);
     void notifyObservers(String message);
 }
 
 class Channel implements Subject {
     private List<Observer> observers = new ArrayList<>();
 
     public void subscribe(Observer o) {
         observers.add(o);
     }
 
     public void unsubscribe(Observer o) {
         observers.remove(o);
     }
 
     public void notifyObservers(String message) {
         for (Observer o : observers) {
             o.update(message);
         }
     }
 
     public void uploadVideo(String title) {
         System.out.println("New video uploaded: " + title);
         notifyObservers("New video: " + title);
     }
 }
 
 class User implements Observer {
     private String name;
 
     public User(String name) {
         this.name = name;
     }
 
     public void update(String message) {
         System.out.println(name + " received notification → " + message);
     }
 }
 
 public class ObserverPattern {
     public static void main(String[] args) {
         Channel channel = new Channel();
 
         Observer jeff = new User("Jeff");
         Observer naqeeb = new User("Naqeeb");
 
         channel.subscribe(jeff);
         channel.subscribe(naqeeb);
 
         channel.uploadVideo("Observer Pattern in Java ");
     }
 }
 