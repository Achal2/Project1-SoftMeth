

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
	
	public void run() {
		System.out.println("Collection Manager starts running.");
		while (0 < 1) {
			String cmd = userin.nextLine();
			user_input = cmd.split(",");
			command = user_input[0];
			
			switch (command) {
				case "A":
					break;
				case "D":
                    break;
				case "PD":
					if (albumList.isEmpty()) {
						System.out.println("Invalid command."); // TODO
						break;
					}
					
					albumList.printByRelease();
					break;
				case "PG":
					if (albumList.isEmpty()) {
						System.out.println("Invalid command."); // TODO
						break;
					}
					
					albumList.printByGenre();
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