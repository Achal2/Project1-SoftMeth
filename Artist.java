

public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;

   public void test() {
    String test = "1/1/1987";
    Date testing = new Date(test);

    Artist artist1 = new Artist("John Doe", new Date("1/1/1987"));

    Artist artist2 = new Artist("John Doe", new Date("1/1/1987"));
    System.out.println(artist1.compareTo(artist2)); // should print 0
    
    Artist artist3 = new Artist("Jane Smith", new Date("2/2/1993"));
    System.out.println(artist1.compareTo(artist3)); // should print positive integer
    
    Artist artist4 = new Artist("Chris Brown", new Date("3/3/1985"));
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