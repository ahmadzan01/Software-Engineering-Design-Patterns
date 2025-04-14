/**
 * 🧠 Adapter Design Pattern
 *
 * 📌 Purpose:
 * The Adapter pattern allows two incompatible interfaces to work together.
 * It acts as a **bridge** between an existing class and the one that needs it.
 *
 * 💡 Real-Life Analogy:
 * Imagine you have a **USB-C laptop** 💻 but your mouse only has a **USB-A plug**.
 * You’d use a **USB-A to USB-C adapter** so it fits — same idea here in code!
 *
 * ✅ Key Features:
 * - Adapts one interface to another expected by the client
 * - Allows reuse of existing functionality without modifying original code
 */

// 🎯 Target interface (what the client expects)
interface MediaPlayer {
    void play(String fileName);
}

// 🧱 Adaptee (existing class with incompatible interface)
class LegacyAudioPlayer {
    public void playFile(String fullPath) {
        System.out.println("Playing file: " + fullPath);
    }
}

// 🧩 Adapter (makes LegacyAudioPlayer work with MediaPlayer)
class AudioAdapter implements MediaPlayer {
    private LegacyAudioPlayer legacyPlayer = new LegacyAudioPlayer();

    public void play(String fileName) {
        legacyPlayer.playFile("music/" + fileName);
    }
}

// 👤 Client code
public class Adapter {
    public static void main(String[] args) {
        MediaPlayer player = new AudioAdapter();
        player.play("song.mp3");  // works even though the formats were incompatible!
    }
}
