import java.util.*;

public class PlayList {
    private String name;
    final private ArrayList<Track> tracks = new ArrayList<>();

    // Create a PlayList with a default name
    public PlayList(){
        this("My Playlist");
    }

    // Create a PlayList with the specified name
    public PlayList(String playListName){
        this.name = playListName;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (Track track : tracks) {
            sb.append(String.format("%s by %s, %s. Duration: %s seconds.\n", track.getTitle(), track.getArtist(), track.getYear(), track.getDuration()));
        }

        return sb.toString();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    // Add a Track where only the title and artist are known
    public void add(String title, String artist){
        this.add(new Track(title, artist));
    }

    // Add a Track where all the data is known
    public void add(String title, String artist, int year, int duration){
        this.add(new Track(title, artist, year, duration));
    }

    // Add a previously created instance of the Track class
    public void add(Track t){
        if(trackDoesNotExist(t)){
            tracks.add(t);
        }
    }

    public boolean remove(String title){
        for(Track track : tracks) {
            //this will get rid of the first song with that name
            if (title.equalsIgnoreCase(track.getTitle())) {
                tracks.remove(track);
                return true;
            }
        }
        return false;
    }

    public void showList(){
        System.out.printf("%s: \n", getName());
        if (tracks.isEmpty()){
            System.out.println("The list is empty");
        } else{
            System.out.println(this.toString());
        }
    }

    public void playAll(boolean random){
        if (random){
            ArrayList<Integer> shuffleNumbers = new ArrayList<>();
            for (int i = 0; i < tracks.size(); i++){
                shuffleNumbers.add(i);
            }
            Collections.shuffle(shuffleNumbers);
            for (int trackIndex : shuffleNumbers){
                playTrack(tracks.get(trackIndex));
            }
        } else{
            for (Track track : tracks){
                playTrack(track);
            }
        }
    }

    public void playOnly(String artist){
        for (Track track : tracks){
            //case-insensitive, and you don't need the full name of an artist
            if(track.getArtist().toLowerCase().contains(artist.toLowerCase())){
                playTrack(track);
            }
        }
    }

    public void playOnly(int year){
        for (Track track : tracks){
            if(year == track.getYear()){
                playTrack(track);
            }
        }
    }

    //I decided only to include one of the same song per playlist.
    //I consider a unique song is where the combination of title, artist, year, and duration is unique.
    private boolean trackDoesNotExist(Track t){
        if (!tracks.isEmpty()) {
            for (Track track : tracks){
                //Unfortunately, I couldn't use the compareTo method in the Track class because it only compares the title, and I am not allowed to update the Track class.
                if((track.getTitle().compareToIgnoreCase(t.getTitle()) == 0) && (track.getArtist().compareToIgnoreCase(t.getArtist()) == 0) && (track.getYear() == t.getYear()) && (track.getDuration() == t.getDuration())){
                    return false;
                }
            }
        }
        return true;
    }

    private void playTrack(Track t){
        System.out.printf("Playing: %s\n", t);
    }
}