import java.lang.*;
import java.io.*; 
import java.util.*; 
  

/*Comparable and Comparator */

class MainSong {
    public static void main(String[] arcs) { 
        List<Song> list = new ArrayList<Song>();
        Song song = new Song("Are you my wife","Jonny Craig", "5", "234");
        Song song2 = new Song("Running", "Kenny", "4", "435");
       
        list.add(song);
        list.add(song2);
        list.add(new Song("Abiam", "Kd", "3", "435234"));//better

        Collections.sort(list);

        for (Song x: list) {
            System.out.println( x.getTitle() + " " + x.getArtist() );
        }
    }
}

class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;
    
    //sort by title
    // @Override
    // public int compareTo(Song s) {
    //     return this.title.compareTo(s.getTitle());
    // }

    //sort by Artist
    @Override
    public int compareTo(Song s) {
        return this.artist.compareTo(s.getArtist());
    }

    Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getRating() {
        return this.rating;
    }

    public String getBpm() {
        return this.bpm;
    }

    @Override
    public String toString() {
        return this.title;
    }
    
}

/*
https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/


https://stackoverflow.com/questions/2266827/when-to-use-comparable-and-comparator
I would say that an object should implement Comparable if that is the clear natural way
 to sort the class, and anyone would need to sort the class would generally want to do it 
 that way.
If, however, the sorting was an unusual use of the class, or the sorting only makes sense
 for a specific use case, then a Comparator is a better option.
Put another way, given the class name, is it clear how a comparable would sort, or do you
 have to resort to reading the javadoc? If it is the latter, odds are every future sorting
  use case would require a comparator, at which point the implementation of comparable may 
  slow down users of the class, not speed them up.


*/