/**
 * This class handles and stores date to all songs in the Music Library
 *
 * @author Andrew_Michaels
 * @version 02_12_2025
 */
public record Song(String artistName, String songName, String albumName, float duration,
                   int releaseYear) implements Comparable<Song> {


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Song other = (Song) obj;
        return this.songName.equals(other.songName) && this.artistName.equals(other.artistName);
    }


    @Override
    public int compareTo(Song other) {
        if (other == null)
            return 1;
        int artistName = this.artistName.compareTo(other.artistName);
        if (artistName != 0) return artistName;
        return songName.compareTo(other.songName);
    }

    @Override
    public String toString() {
        return String.format("| %2s | %2s | %2s | %2d | %2.2f",  artistName, songName, albumName, releaseYear, duration);
    }

}
