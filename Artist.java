

public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;

   public void test() {
    String test = "10/28/1987";
    Date testing = new Date(test);

    Artist artist1 = new Artist("Frank Ocean", new Date("10/28/1987"));

    Artist artist2 = new Artist("Frank Ocean", new Date("10/28/1987"));
    System.out.println(artist1.compareTo(artist2)); // should print 0
    
    Artist artist3 = new Artist("Lamelo Ball", new Date("8/22/2001"));
    System.out.println(artist1.compareTo(artist3)); // should print positive integer
    
    Artist artist4 = new Artist("Alicia Keys", new Date("1/25/1981"));
    System.out.println(artist1.compareTo(artist4)); // should print negative integer

   }

  
    public Artist(String name, Date born) {
        this.name = name;
        this.born = born;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getBorn() {
        return born;
    }


    public void setBorn(Date born) {
        this.born = born;
    }

    @Override
    public int compareTo(Artist other) {
        int nameComparison = this.name.compareToIgnoreCase(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }

        return this.born.compareTo(other.born);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Artist artist = (Artist) obj;
        return name.equalsIgnoreCase(artist.name) && born.equals(artist.born);
    }

    @Override
    public String toString() {
        return "Artist: " + name + ", Born: " + born;
    }

    public 
    }
}

}