

public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;


//   public void test() {
//       String test = "10/28/1987";
//    Date testing = new Date(test);
//
//    Artist artist1 = new Artist("Frank Ocean", new Date("10/28/1987"));
//
//    Artist artist2 = new Artist("Frank Ocean", new Date("10/28/1987"));
//    System.out.println(artist1.compareTo(artist2)); // should print 0
//
//    Artist artist3 = new Artist("Lamelo Ball", new Date("8/22/2001"));
//    System.out.println(artist1.compareTo(artist3)); // should print positive integer
//
//    Artist artist4 = new Artist("Alicia Keys", new Date("1/25/1981"));
//    System.out.println(artist1.compareTo(artist4)); // should print negative integer

   }


    /**
     *Constructor for creating an Artist object.
     * @param name The name of the artist
     * @param born The date of birth of the artist.
     */
    public Artist(String name, Date born) {
        this.name = name;
        this.born = born;
    }


    /**
     * Retrieves the name of the artist
     * @return The name of the artist
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the artist.
      * @param name The new name for the artist.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Retrieves the date of birth of the artist.
      * @return The date of birth of the artist.
     */
    public Date getBorn() {
        return born;
    }


    /**
     * Sets the date of birth of the artist.
     * @param born The new date of birth for the artist.
     */
    public void setBorn(Date born) {
        this.born = born;
    }

    /**
     * Compares this artist with another artist based on their names and dates of birth.
      * @param other The other artist to compare with.
     * @return A negative integer, zero, or a positive integer as this artist is less than, equal to, or greater than the other artist.
     */
    @Override
    public int compareTo(Artist other) {
        int nameComparison = this.name.compareToIgnoreCase(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }

        return this.born.compareTo(other.born);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
      * @param obj The object to compare equality with.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Artist artist = (Artist) obj;
        return name.equalsIgnoreCase(artist.name) && born.equals(artist.born);
    }

    /**
     * Returns a string representation of the artist.
      * @return A string representation of the artist, including their name and date of birth.
     */

    @Override
    public String toString() {
        return "Artist: " + name + ", Born: " + born;
    }

    public 
    }
}

}