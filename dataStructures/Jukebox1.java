import java.util.*;
import java.io.*;

public class Jukebox1 {
    List<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
    }

    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=reader.readLine()) != null) {
                addSong(line);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
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




*/