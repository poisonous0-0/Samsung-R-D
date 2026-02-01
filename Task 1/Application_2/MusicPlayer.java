import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> playlist;
    private int currentIndex;
    private boolean isPlaying;
    
    public MusicPlayer() {
        this.playlist = new ArrayList<>();
        this.currentIndex = 0;
        this.isPlaying = false;
        initializePlaylist();
    }
    
    private void initializePlaylist() {
        playlist.add(new Music("Bohemian Rhapsody", "Queen", 354));
        playlist.add(new Music("Imagine", "John Lennon", 183));
        playlist.add(new Music("Stairway to Heaven", "Led Zeppelin", 482));
        playlist.add(new Music("Hey Jude", "The Beatles", 427));
        playlist.add(new Music("Hotel California", "Eagles", 391));
        playlist.add(new Music("Sweet Child o' Mine", "Guns N' Roses", 356));
        playlist.add(new Music("Smells Like Teen Spirit", "Nirvana", 301));
        playlist.add(new Music("Hallelujah", "Leonard Cohen", 268));
    }
    
    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }
        
        isPlaying = true;
        System.out.println("\n Now Playing: " + playlist.get(currentIndex).toString());
    }
    
    public void pause() {
        if (!isPlaying) {
            System.out.println("No music is currently playing!");
            return;
        }
        
        isPlaying = false;
        System.out.println("\n Paused: " + playlist.get(currentIndex).toString());
    }
    
    public void stop() {
        isPlaying = false;
        System.out.println("\n Music stopped!");
    }
    
    public void playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }
        
        currentIndex = (currentIndex + 1) % playlist.size();
        isPlaying = true;
        System.out.println("\n⏭ Next Track: " + playlist.get(currentIndex).toString());
    }
    
    public void playPrevious() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }
        
        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
        isPlaying = true;
        System.out.println("\n⏮ Previous Track: " + playlist.get(currentIndex).toString());
    }
    
    public void displayStatus() {
        System.out.println("\n--- Current Status ---");
        if (isPlaying) {
            System.out.println("Status: Playing");
        } else {
            System.out.println("Status: Paused/Stopped");
        }
        System.out.println("Current Track: " + playlist.get(currentIndex).toString());
        System.out.println("Position: " + (currentIndex + 1) + "/" + playlist.size());
    }
    
    public void displayPlaylist() {
        System.out.println("\n Playlist ");
        for (int i = 0; i < playlist.size(); i++) {
            String marker = (i == currentIndex) ? " > " : "   ";
            System.out.println(marker + (i + 1) + ". " + playlist.get(i).toString());
        }
    }
    
    public boolean isPlaying() {
        return isPlaying;
    }
    
    public int getPlaylistSize() {
        return playlist.size();
    }
}
