
public class Rating {
    private int star;
    private Rating next;


    /**
     * Constructs a Rating object with the given star rating.
      * @param star The star rating of the object.
     */
    public Rating(int star) {
        this.star = star;
        this.next = null;
    }

    /**
     * Gets the star rating of the object.
     * @return The star rating of the object.
     */
    public int getStar() {
        return star;
    }

    /**
     * Sets the star rating of the object.
     * @param star The star rating to set.
     */
    public void setStar(int star) {
        this.star = star;
    }

    /**
     * Retrieves the next rating in the sequence.
     * @return The next rating in the sequence
     */
    public Rating getNext() {
        return next;
    }

    /**
     * Sets the next rating in the sequence.
     * @param next The next rating to set.
     */
    public void setNext(Rating next) {
        this.next = next;
    }
}