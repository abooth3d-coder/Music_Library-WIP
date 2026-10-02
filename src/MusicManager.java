import java.util.*;
import java.io.*;
/**
 * A class that handles the logic for managing the music library to include features such as adding new songs, and
 * filter search by artist, album, song or year.
 * @author Andrew_Michaels
 * @version 04/12/25
 */
public class MusicManager
{
    private static final ArrayList<Song> SONGS = new ArrayList<>();
    private static final Scanner SCANNER = Main.getScanner();
    private static final ArrayList<Song> FILTERED_SONGS = new ArrayList<>();

    public MusicManager()
    {
        clearList();
        populateSongs();
        for (Song song : SONGS)
        {
            System.out.println(song);
        }
        System.out.printf("%nTime Duration: %3d mins",calculateTotalMinDuration(SONGS));
    }

    /**
     * A void method that clears the ArrayList
     */
    private void clearList()
    {
        SONGS.clear();
    }

    private void clearFilteredList()
    {
        FILTERED_SONGS.clear();
    }

    /**
     * A private method that extracts a music list from a CSV file(coming soon), parse into correct format and populates
     * into the ArrayList SONGS field.
     */
    private void populateSongs()
    {
        //substitute to CSV file for now
        String[] songData = new String[3];
        songData[0] = "Ed Sheeran,Perfect,Divide,2017,4.23";
        songData[1] = "Alexandra Burke,Hallelujah,Overcome,2008,3.38";
        songData[2] = "Band Aid,Do They Know It's Christmas?,n/a,1984,3.43";

        //parse data Within each song into the correct format
        for (String song : songData)
        {
            String[] songInfo = song.split(",");
            String artistName = songInfo[0];
            String songName = songInfo[1];
            String albumName = songInfo[2];
            int releaseYear = Integer.parseInt(songInfo[3]);
            float duration = Float.parseFloat(songInfo[4]);

            //Creat and add song to list
            addToList( createSong(artistName, songName, albumName, duration, releaseYear) );
        }
    }

    private Song createSong(String artistName, String songName, String albumName, float duration, int releaseYear)
    {
       return new Song(artistName, songName, albumName, duration, releaseYear);
    }

    /**
     * A private helped method that adds a song to the ArrayList SONGS
     * @param song a Song parameter that represents the song to be added to the list
     */
    private void addToList(Song song)
    {
        SONGS.add(song);
    }


    public boolean addSong()
    {
        boolean added = false;

        //Creates artistName
        System.out.println("Please enter the name of the artist you would like to add:\n");
        String artistName = SCANNER.nextLine();

        //creates songName
        System.out.println("\nPlease enter the name of the song you would like to add:\n");
        String songName = SCANNER.nextLine();

        //creates albumName
        System.out.println("\nPlease enter the album name of the song you would like to add:\n");
        String albumName = SCANNER.nextLine();

        //creates yearOfRelease
        System.out.println("\nPlease enter the year of the song you would like to add:\n");
        int releaseYear = SCANNER.nextInt();

        //create songDuration
        System.out.println("\nPlease enter the duration of the song you would like to add:\n");
        float duration = Float.parseFloat(SCANNER.nextLine());

        Song newSong = createSong(artistName, songName, albumName, duration, releaseYear);

        for (Song song : SONGS)
        {
            if(newSong.equals(song)) System.err.println("Song already exists!");
            else
            {
                SONGS.add(newSong);
                added = true;
                break;
            }
        }
        return added;
    }

    private int calculateTotalMinDuration(ArrayList<Song> filteredList)
    {
        int maxMinDuration = 0;
        float sumDuration = 0;
        for (Song song : filteredList)
        {
            sumDuration += song.duration();
            while (sumDuration>1.00)
            {
                maxMinDuration++;
                sumDuration -= 1.00F;
            }
            if(sumDuration>=0.60)
            {
                maxMinDuration++;
                sumDuration -= 0.60F;
            }
        }
        return maxMinDuration;
    }

}
