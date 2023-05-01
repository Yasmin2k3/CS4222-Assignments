public class PlaylistDriver {
    public static void main(String[] args) {
        //I know that this uses all methods in the Playlist class because my IDE mentions if a method hasn't been used.

        //testing that showList works
        testShowList();

        //breaks to make the tests more readable
        System.out.println();

        testNoDuplicates1();

        System.out.println();

        testNoDuplicates2();

        System.out.println();

        //testing that getName works
        testGetName();

        System.out.println();

        //testing that setName works
        testSetName();

        System.out.println();

        testTwoValues();

        System.out.println();

        testAllValues();

        System.out.println();

        testTrack();

        System.out.println();

        testPlayNotShuffled();

        System.out.println();

        testPlayShuffled();

        System.out.println();

        testPlayOnlyYear();

        System.out.println();

        testPlayOnlyArtist1();

        System.out.println();

        testPlayOnlyArtist2();

        System.out.println();

        testRemove();
    }

    private static void testShowList(){
        PlayList pl = new PlayList();
        System.out.println("Showing a playlist while it is empty." +
                "\nExpected result: My Playlist:\nThis list is empty.\nOutput: ");
        pl.showList();
    }
    private static void testSetName(){
        PlayList pl = new PlayList();
        System.out.printf("Testing set name" +
                "\nOriginal name: %s\nExpected result: setName Works\n", pl.getName());
        pl.setName("setName Works");
        System.out.printf("Output: %s\n", pl.getName());
    }

    private static void testGetName(){
        PlayList pl1 = new PlayList();
        PlayList pl2 = new PlayList("getName works");

        System.out.printf("Testing get name\n" +
                "Expected result 1: My Playlist\nOutput: %s\nExpected result 2: getName works\nOutput: %s\n", pl1.getName(), pl2.getName());
    }

    //testing that you can add to the playlist with the title and name only
    private static void testTwoValues(){
        PlayList pl = new PlayList();

        pl.add("Leningrad","Billy Joel");
        pl.add("Separate Lives","Marilyn Martin & Phil Collins");
        pl.add("Flowers Are Red","Harry Chapin");

        System.out.println("Test to add to the playlist with title and name only\n" +
                "Expected Output:\nMy Playlist: \nLeningrad by Billy Joel, 0. Duration: 0 seconds." +
                "\nSeparate Lives by Marilyn Martin & Phil Collins, 0. Duration: 0 seconds." +
                "\nFlowers Are Red by Harry Chapin, 0. Duration: 0 seconds.\n\nOutput:");

        pl.showList();
    }

    private static void testAllValues(){
        PlayList pl = new PlayList();

        pl.add("The Times They Are A-Changin'","Bob Dylan",1964,192/*3:12*/);
        pl.add("Desperado","Eagles",1973,214/*3:34*/);
        pl.add("Let It Be","The Beatles",1970,230/*3:50*/);

        System.out.println("Test to add to the playlist with all values inputted\n" +
                "Expected Output:\nMy Playlist: \nThe Times They Are A-Changin' by Bob Dylan, 1964. Duration: 192 seconds.\n" +
                "Desperado by Eagles, 1973. Duration: 214 seconds." +
                "\nLet It Be by The Beatles, 1970. Duration: 230 seconds.\n\nOutput:");

        pl.showList();
    }

    private static void testTrack(){
        PlayList pl = new PlayList();

        pl.add(new Track("Acrobat","U2",1980,270/*4:30*/));
        pl.add(new Track("Turn It On Again","Genesis",1980,231/*3:51*/));

        System.out.println("Test to add to the playlist with a Track inputted\n" +
                "Expected Output:\nMy Playlist: \nAcrobat by U2, 1980. Duration: 270 seconds.\n" +
                "Turn It On Again by Genesis, 1980. Duration: 231 seconds.\n\nOutput:");

        pl.showList();
    }

    private static void testNoDuplicates1(){
        PlayList pl = new PlayList();

        pl.add("The Times They Are A-Changin'","Bob Dylan",1964,192/*3:12*/);
        pl.add("The Times They Are A-Changin'","Bob Dylan",1964,192/*3:12*/);
        pl.add("Desperado","Eagles",1973,214/*3:34*/);
        pl.add("Desperado","Eagles",1973,214/*3:34*/);

        System.out.println("Test that there will be no duplicates in a playlist:\n" +
                "Expected Output:\nMy PLaylist:\nThe Times They Are A-Changin' by Bob Dylan, 1964. Duration: 192 seconds." +
                "\nDesperado by Eagles, 1973. Duration: 214 seconds.\nOutput:");

        pl.showList();
    }

    private static void testNoDuplicates2(){
        PlayList pl = new PlayList();

        pl.add("The Times They Are A-Changin'","Bob Dylan",1964,192/*3:12*/);
        pl.add("The Times They Are A-Stagnant","Bob Dylan",1964,192/*3:12*/);   //title changed
        pl.add("The Times They Are A-Changin'","Bib Dylan",1964,192/*3:12*/);   //artist name changed
        pl.add("The Times They Are A-Changin","Bob Dylan",1974,192/*3:34*/);    //year changed
        pl.add("The Times They Are A-Changin","Bob Dylan",1964,191/*3:34*/);    //duration changed

        System.out.println("Test that songs will be added if any of the values are different from another song:\n" +
                "Expected Output:\nMy Playlist:\nThe Times They Are A-Changin' by Bob Dylan, 1964. Duration: 192 seconds." +
                "\nThe Times They Are A-Stagnant by Bob Dylan, 1964. Duration: 192 seconds." +
                "\nThe Times They Are A-Changin' by Bib Dylan, 1964. Duration: 192 seconds.\n" +
                "The Times They Are A-Changin by Bob Dylan, 1974. Duration: 192 seconds." +
                "\nThe Times They Are A-Changin by Bob Dylan, 1964. Duration: 191 seconds.\nOutput:");

        pl.showList();
    }
    private static void testPlayNotShuffled(){
        PlayList pl = new PlayList();
        pl.add("Leningrad","Billy Joel");
        pl.add("Separate Lives","Marilyn Martin & Phil Collins");
        pl.add("The Times They Are A-Changin'","Bob Dylan",1964,192/*3:12*/);
        pl.add("Desperado","Eagles",1973,214/*3:34*/);
        pl.add("Let It Be","The Beatles",1970,230/*3:50*/);
        pl.add(new Track("Acrobat","U2",1980,270/*4:30*/));

        System.out.println("Test to play all songs in a playlist un-shuffled.\n" +
                "Expected Output:\n" + "Playing: <LENINGRAD><Billy Joel><   0><00:00>\n" +
                "Playing: <SEPARATE LIVES><Marilyn Martin & Phil Collins><   0><00:00>\n" +
                "Playing: <THE TIMES THEY ARE A-CHANGIN'><Bob Dylan><1964><03:12>\n" +
                "Playing: <DESPERADO><Eagles><1973><03:34>\n" +
                "Playing: <LET IT BE><The Beatles><1970><03:50>\n" +
                "Playing: <ACROBAT><U2><1980><04:30>\nOutput:");

        pl.playAll(false);
    }

    private static void testPlayShuffled(){
        PlayList pl = new PlayList();
        pl.add("Leningrad","Billy Joel");
        pl.add("Separate Lives","Marilyn Martin & Phil Collins");
        pl.add("The Times They Are A-Changin'","Bob Dylan",1964,192/*3:12*/);
        pl.add("Desperado","Eagles",1973,214/*3:34*/);
        pl.add("Let It Be","The Beatles",1970,230/*3:50*/);
        pl.add(new Track("Acrobat","U2",1980,270/*4:30*/));

        System.out.println("Test to play all songs in a playlist shuffled.\n" +
                "Expected Output:\nAll songs in the playlist are played not in order, with no repeating songs. Original order:");
        pl.showList();
        System.out.println("Output:");
        pl.playAll(true);
        System.out.println("Show that actual playlist is not affected by the shuffle:");
        pl.showList();
    }

    private static void testPlayOnlyYear(){
        PlayList pl = new PlayList();

        pl.add(new Track("Acrobat","U2",1980,270/*4:30*/));
        pl.add(new Track("Turn It On Again","Genesis",1980,231/*3:51*/));
        pl.add(new Track("The Climb","Miley Cyrus",2009,241/*4:01*/));

        System.out.println("Test that songs from a specific year are played:\n" +
                "Expected Output:\nPlaying: <ACROBAT><U2><1980><04:30>\n" +
                "Playing: <TURN IT ON AGAIN><Genesis><1980><03:51>\nOutput:");

        pl.playOnly(1980);
    }

    private static void testPlayOnlyArtist1(){
        PlayList pl = new PlayList();

        pl.add(new Track("Acrobat","U2",1980,270/*4:30*/));
        pl.add(new Track("Wrecking Ball","Miley Cyrus",1980,231/*3:51*/));
        pl.add(new Track("The Climb","Miley Cyrus",2009,241/*4:01*/));

        System.out.println("Test that songs from a specific artist are played:\n" +
                "Expected Output:\nPlaying: <WRECKING BALL><MILEY CYRUS><1980><04:30>\n" +
                "Playing: <THE CLIMB><MILEY CYRUS><1980><03:51>\nOutput:");

        pl.playOnly("Miley Cyrus");
    }

    private static void testPlayOnlyArtist2(){
        PlayList pl = new PlayList();

        pl.add(new Track("Acrobat","U2",1980,270/*4:30*/));
        pl.add(new Track("Wrecking Ball","Miley Cyrus",1980,231/*3:51*/));
        pl.add(new Track("The Climb","Miley Cyrus",2009,241/*4:01*/));

        System.out.println("Test that songs from a specific artist are played, full name not needed, case insensitive:\n" +
                "Expected Output:\nPlaying: <WRECKING BALL><Miley Cyrus><1980><03:51>\n" +
                "Playing: <THE CLIMB><Miley Cyrus><2009><04:01>\nOutput:");

        pl.playOnly("MiLey");
    }

    private static void testRemove(){
        PlayList pl = new PlayList();

        pl.add("Leningrad","Billy Joel");
        pl.add(new Track("Acrobat","U2",1980,270/*4:30*/));
        pl.add("Separate Lives","Marilyn Martin & Phil Collins");
        pl.add("Flowers Are Red","Harry Chapin");

        pl.remove("LenINGRad"); // Remove Billy Joel's Leningrad
        pl.remove("Acribat"); // Nothing removed - Acribat not found
        pl.remove("FlowErS Are RED"); // Remove Harry Chapin's Flowers are red

        System.out.println("Test that remove function removes a specific track, and is case insensitive\n" +
                "Expected Output:\nMy Playlist:\nAcrobat by U2, 1980. Duration: 270 seconds." +
                "\nSeparate Lives by Marilyn Martin & Phil Collins, 0. Duration: 0 seconds.\nOutput:");

        pl.showList();

    }
}