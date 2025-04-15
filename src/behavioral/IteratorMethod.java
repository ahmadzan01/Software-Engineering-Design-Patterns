/**
 * 🧠 Iterator Design Pattern
 *
 * 📌 Purpose:
 * The Iterator pattern provides a way to **access elements of a collection sequentially**
 * without exposing the collection's underlying structure.
 *
 * 💡 Real-Life Analogy:
 * Think of a **playlist** on Spotify 🎵 — you press "Next" or "Previous" to go through songs.
 * You don’t care how the playlist is stored — you just want to loop through them.
 *
 * ✅ Key Features:
 * - Separates the logic of traversing from the collection itself
 * - Provides a standard way to loop through different data structures
 */

// Collection interface
interface SongCollection {
    Iterator getIterator();
}

// Iterator interface
interface Iterator {
    boolean hasNext();
    String next();
}

// Concrete collection
class Playlist implements SongCollection {
    private String[] songs = {"Lose Yourself", "Blinding Lights", "God's Plan"};

    public Iterator getIterator() {
        return new PlaylistIterator();
    }

    // Inner class: Iterator implementation
    private class PlaylistIterator implements Iterator {
        int index = 0;

        public boolean hasNext() {
            return index < songs.length;
        }

        public String next() {
            if (this.hasNext()) {
                return songs[index++];
            }
            return null;
        }
    }
}

// Client
public class IteratorMethod {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Iterator it = playlist.getIterator();

        while (it.hasNext()) {
            System.out.println("Now playing: " + it.next());
        }
    }
}
