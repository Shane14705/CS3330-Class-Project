package LibrarySystem.LibraryCollection;

import java.util.Date;

public class LibraryNewspaper extends LibraryItem {
    private int ISSN[];
    private Date Pub_Date;
    private String Publisher;

    /**
     * Gets the 8 digit ISSN number for this newspaper edition.
     * @return Int array of 8 digits representing the valid ISSN of this newspaper edition
     */
    public int[] getISSN() {
        return ISSN;
    }

    /**
     * Function to validate and update the ISSN number for this newspaper edition.
     * @param ISSN Int array of 8 digits representing the valid ISSN of this newspaper edition
     */
    public void setISSN(int[] ISSN) {
        if(ISSN.length != 8)
        {
            throw new IllegalArgumentException("ISSN must be 8 digits.");
        }
        else
        {
            //This goes through the actual ISSN calculation method to ensure it's an accurate ISSN
            int total=0;
            for(int i=0; i<8; i++)
            {
                total+=(ISSN[i]*(8-i));
            }
            if(total%11 != 0)
            {
                throw new IllegalArgumentException("This ISSN is not legal.");
            }
        }
        this.ISSN = ISSN;
    }

    /**
     * Gets the date on which this newspaper edition was published.
     * @return Date object representing the date on which this newspaper edition was published
     */
    public Date getPub_Date() {
        return Pub_Date;
    }

    /**
     * Updates the date on which this newspaper edition was published.
     * @param pub_Date Date object representing the date on which this newspaper edition was published
     */
    public void setPub_Date(Date pub_Date) {
        Pub_Date = pub_Date;
    }

    /**
     * Gets the publisher of this newspaper edition.
     * @return String representing the name of the publisher of this newspaper edition
     */
    public String getPublisher() {
        return Publisher;
    }

    /**
     * Updates the publisher of this newspaper edition.
     * @param publisher String representing the new name of the publisher of this newspaper edition
     */
    public void setPublisher(String publisher) {
        Publisher = publisher;
    }




    //TODO: Finish filling out the documentation for the parameters here
    /**
     * Constructs a Newspaper item for the collection. Each edition of a Newspaper in the library should be represented by one instance of this object
     * @param ISSN
     * @param Pub_Date
     * @param Publisher
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this newspaper edition in the collection
     * @param price Float representing the price of one copy of this newspaper edition (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this newspaper edition that will currently be available to borrow
     */
    public LibraryNewspaper(int[] ISSN, Date Pub_Date, String Publisher, char[] ID_num, float price, int numberAvailable){
        super(ID_num, LibrarySection.NEWSPAPERS, price, numberAvailable);
        setISSN(ISSN);
        setPub_Date(Pub_Date);
        setPublisher(Publisher);
    }
}
