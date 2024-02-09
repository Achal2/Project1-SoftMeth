import java.util.Date;

public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;

  
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
}