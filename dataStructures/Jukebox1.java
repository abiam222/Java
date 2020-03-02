import java.util.*;
import java.io.*;

public class Jukebox1 {
    List<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtists().compareTo(two.getArtists());
        }
    }

    public void go() {
        getSongs();
        System.out.println(songList);//regular list
        Collections.sort(songList);
        System.out.println(songList);//list sorted by title

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);//bc we want two different view
        //of the song list, one by song title and one by artist
        System.out.println(songList);//song sorted by artist
    }

    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=reader.readLine()) != null) {
                addSong(line);
            }
            reader.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
        songList.add(nextSong);
    }
}

/*
ArrayList doesn't have a sort method.

TreeSet: Keeps the elements sorted and prevents duplicats

HashMap: Lets you store and acess element as name/value pairs

LinkedList: Give better performance when you insert and delete elements from the 
middle collection (in practice ArrayList is what you want)

HashSet: Prevents duplicates in the collection and given an element can find that 
elemtn in the collection quickly

LinkedHashMap: Like a regular HashMap, except it can remember the order in which 
elements (name/value pairs) were inserted, or it can be configred to remember the 
order in which elements were last accessed

ArrayList is faster than TreeSet because it cost to sort the elements and have them
in order


Now java.nio.file preferred package for files
-java.io FileXXX streams are deprecated


*/