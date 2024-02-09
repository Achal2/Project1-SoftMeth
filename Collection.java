

public class Collection {
	

	private Album[] albums = new Album[4];
	private int size;
	private int numAlbums; // number of albums currently in the collection

	
	private int find(Album album) {
		for (int i = 0; i < albums.length; i++) {
			if (albums[i] != null) {
				if (albums[i].getTitle().equals(album.getTitle()) && albums[i].getArtist().equals(album.getArtist())) {
					return i;
				}
			}

		}

		return -1;
	}


	private void grow() {
		Album newArray[] = new Album[albums.length + 4];

		for (int i = 0; i < albums.length; i++) {
			newArray[i] = albums[i];
			albums = newArray;
		}
	} 


    public boolean contains(Album album){
        if (find(album) >= 0)
            return true;
        return false;
    }

	public boolean add(Album album) {
	
		
		if (!album.getReleased().isValid()) {
			
			return false;
		}


		for (int i = 0; i < albums.length; i++) {
			if (albums[i] == null) {
				albums[i] = album;
				numAlbums++;
				return true;
			}
		}
		if (numAlbums == albums.length) {
			grow();
		}

		return false;
	}

	
	public boolean remove(Album album) {

		int index = find(album);
		if (index == -1) {
			return false;
		}
		Album tempArr[] = new Album[albums.length - 1];

		for (int i = 0, k = 0; i < albums.length; i++) {
			if (i == index) {
				continue;
			}
			tempArr[k++] = albums[i];
		}
		albums = tempArr;
		return true;
	}


	
	public void printByRelease() {
		if (numAlbums == 0)
			System.out.println("Invalid Command!");
		else {
			Album arr[] = albums;
			int n = albums.length;

			
			for (int i = 0; i < n - 1; i++) {
				
				int min_idx = i;
				for (int j = i + 1; j < n; j++) {
					if (albums[j]!=null) {
						if (albums[j].getReleased().compareTo(albums[min_idx].getReleased()) < 0)
							min_idx = j;
					}
				}
				
				Album temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
			System.out.println("*Album collection by the release dates.");
			for (int i=0;i<arr.length;i++) {
				System.out.println(arr[i]); 
			}
			System.out.println("*End of list");
		}
	}

	
	public void printByGenre() {
		if (numAlbums == 0)
			System.out.println("Invalid Command!");
		else {
			Album arr[] = albums;
			for (int i = 0; i < arr.length; i++) {
				int smallest = i;
				for (int j = i + 1; j < arr.length; j++) 
				{
					if (albums[j]!=null) {

						if (arr[j].getGenre().compareTo(arr[i].getGenre()) < 0)
							smallest = j;
					}
				}	
				
				Album a = arr[i];
				arr[i] = arr[smallest];
				arr[smallest] = a;
			}
			System.out.println("*Album collection by genre");
			for (int i=0;i<arr.length;i++) {
				System.out.println(arr[i]); 
			}
			System.out.print("*End of list");
		}
	}
	
	public void printByRating() {
		for (int i = 0; i < size - 1; i++) { // Bubble sort by average rating, then title
			for (int j = 0; j < size - i - 1; j++) {
				if (albums[j].getAverageRating() < albums[j + 1].getAverageRating() ||
					(albums[j].getAverageRating() == albums[j + 1].getAverageRating() &&
					albums[j].getTitle().compareTo(albums[j + 1].getTitle()) > 0)) { // Swap albums[j] and albums[j + 1]
					Album temp = albums[j];
					albums[j] = albums[j + 1];
					albums[j + 1] = temp;
				}
			}
		}
	
		System.out.println("*Album collection by rating");
		for (int k = 0; k < size; k++) {
			System.out.println(albums[k]);
			}
			System.out.print("*End of list");	
	}

	public boolean isEmpty() {
		if (numAlbums == 0) {
			return true;
		}
		
		return false;
	}
	
	public int length() {
		if (albums == null) {
			return 0;
		}
		
		 return albums.length;
	}
	
	public Album[] getAlbums() {
		return albums;
	}
}