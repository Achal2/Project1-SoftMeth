
public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings;

    
    public Album(String title, Artist artist, Genre genre, Date released) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.released = released;
        this.ratings = null;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
		this.title = title;
	}

    public Artist getArtist(){
        return artist;
    }

    public void setArtist(Artist artist){
        this.artist=artist;
    }

    public Genre getGenre(){
        return genre;
    }

    public void setGenre(Genre genre){
        this.genre=genre;
    }

    public Date getReleased(){
        return released;
    }

    public void setReleased(Date released){
        this.released = released;
    }

    public void rate(int star) {
        Rating newRating = new Rating(star);
        if (ratings == null) {
            ratings = newRating;
        } else {
            Rating current = ratings;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newRating);
        }
    }

    public double avgRatings() {
        if (ratings == null) {
            return 0.0; 
        }

        int sum = 0;
        int count = 0;
        Rating current = ratings;

        while (current != null) {
            sum += current.getStar();
            count++;
            current = current.getNext();
        }

        return (double) sum / count;
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Album album = (Album) obj;
        return title.equalsIgnoreCase(album.title) && artist.equals(album.artist);
    }

    @Override
    public String toString() {
    String result = "Title: " + title + ", Artist: " + artist + ", Genre: " + genre + ", Released: " + released + ", Average Ratings: " + avgRatings() + "\nRatings: ";
    Rating current = ratings;
    while (current != null) {
        result += "*(" + current.getStar() + ") ";
        current = current.getNext();
    }
    
    return result;
}



}
