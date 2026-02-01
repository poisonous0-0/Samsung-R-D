public class Music {
    private String title;
    private String artist;
    private double duration; // in seconds
    
    public Music(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public double getDuration() {
        return duration;
    }
    
    @Override
    public String toString() {
        return title + " - " + artist + " (" + duration + "s)";
    }
}
