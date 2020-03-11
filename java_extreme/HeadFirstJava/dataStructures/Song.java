class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    @Override
    public int compareTo(Song s) {
        return this.title.compareTo(s.getTitle());    
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

    public String getArtists() {
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
        return this.title;//bc when we do System.out.println(aSongoObject)
        //we want the title
    }

}