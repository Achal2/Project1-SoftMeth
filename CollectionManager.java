

import java.util.Scanner;
import java.util.StringTokenizer;


public class CollectionManager {
    Scanner userin = new Scanner(System.in);
    String[] user_input = new String[5];
    String command = null;

    String request,title, artist, rdate;
    String string_genre = "null";

    Album album = null;
    Collection albumList = new Collection();
    Date release = new Date();
    int z = 0;

    public boolean albumExists(Album album) {
        if (albumList.length() == 0) {
            return false;
        }


        for (int i = 0; i < albumList.length(); i++) {
            if (albumList.getAlbums()[i] != null) {
                if (albumList.getAlbums()[i].equals(album)) {
                    return true;
                }
            }
        }


        return false;
    }

    public Album findAlbum(String title, String artist) {
        for (int i = 0; i < albumList.getAlbums().length; i++) {
            if (albumList.getAlbums()[i] != null) {
                if (albumList.getAlbums()[i].getTitle().equals(title) && albumList.getAlbums()[i].getArtist().equals(artist)) {
                    return albumList.getAlbums()[i];
                }
            }

        }
        return null;
    }


    private void addAlbum(String[] tokens) {
        String title = tokens[1];
        String artistName = tokens[2];
        String artistDob = (tokens[3]);
        Genre genre = Genre.valueOf(tokens[4].toUpperCase()); // Parse genre string to enum
        String releaseDate = (tokens[5]);

        Date rDate = new Date(releaseDate);
        Date born = new Date (artistDob);


        // Create an artist object
        Artist artist = new Artist(artistName, born);

        // Create an album object
        Album album = new Album(title, artist, genre, rDate);

        // Add the album to the collection
        boolean added = albumList.add(album);
        if (added) {
            System.out.println("Album added successfully.");
        } else {
            System.out.println("Failed to add album.");
        }
    }


    private void removeAlbum(String[] tokens) {
        String title = tokens[1];
        String artistName = tokens[2];

        // Create an album object for comparison
        Album albumToRemove = new Album(title, new Artist(artistName, new Date()), Genre.Unknown, new Date());

        // Remove the album from the collection
        boolean removed = albumList.remove(albumToRemove);
        if (removed) {
            System.out.println("Album removed successfully.");
        } else {
            System.out.println("Failed to remove album.");
        }
    }

    private void rateAlbum(String[] tokens) {
        String title = tokens[1];
        String artistName = tokens[2];
        int ratingValue = Integer.parseInt(tokens[4]);

        // Find the album in the collection
        Album album = findAlbum(title, artistName);

        if (album != null) {
            // Rate the album
            album.rate(ratingValue);
            System.out.println("Album rated successfully.");
        } else {
            System.out.println("Album not found.");
        }
    }




    public void run() {
        System.out.println("Collection Manager starts running.");
        while (0 < 1) {
            String cmd = userin.nextLine();
            user_input = cmd.split(",");
            command = user_input[0];

            switch (command) {
                case "A":
                    addAlbum(user_input);
                    break;
                case "D":
                    removeAlbum(user_input);
                    break;
                case "R":
                    rateAlbum(user_input);
                    break;
                case "PD":
                   albumList.printByRelease();
                    break;
                case "PG":
                    albumList.printByGenre();
                    break;
                case "PR":
                    albumList.printByRating();
                    break;
                case "Q":
                    System.out.println("Collection Manager terminated.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }


}