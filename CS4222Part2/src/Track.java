
public class Track implements Comparable<Track> {
    // Instance Variables
    private String title;
    private String artist;
    private int year;
    private int duration;

    public Track(String title, String artist) {
        this(title, artist, 0, 0);
    }

    public Track (String title, String artist, int year) {
        this(title, artist, year, 0);
    }

    public Track (String title, String artist, int year, int duration) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public String toString() {
        // Getting seconds in minutes and seconds
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("<%S><%s><%04d><%02d:%02d>", this.title, this.artist, this.year, minutes, seconds);
    }

    public int compareTo(Track other) {
        return this.title.compareTo(other.title);
    }
}