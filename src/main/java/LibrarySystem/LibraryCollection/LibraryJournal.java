package LibrarySystem.LibraryCollection;

public class LibraryJournal extends LibraryItem {
    private int ISSN[], Volume, Issue;
    private String Title, Publisher;

    /**
     * Gets the 8 digit ISSN number for this newspaper edition.
     * @return Int array of 8 digits representing the valid ISSN of this newspaper edition
     */
    public int[] getISSN(){
        return ISSN;
    }

    /**
     * Function to validate and update the ISSN number for this newspaper edition.
     * @param ISSN Int array of 8 digits representing the valid ISSN of this newspaper edition
     */
    public void setISSN(int[] ISSN){
        if(ISSN.length != 8)
        {
            throw new IllegalArgumentException("ISSN must be 8 digits.");
        }
        else
        {
            //This goes through the actual ISSN calculation method to ensure it's an accurate ISSN.
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
     * Gets the title of this journal.
     * @return String representing the title of this journal
     */
    public String getTitle() {
        return Title;
    }

    /**
     * Updates the title of this journal.
     * @param Title String representing the updated title of this journal
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * Gets the volume number of this journal edition.
     * @return Int representing the volume number of this journal edition
     */
    public int getVolume() {
        return Volume;
    }

    /**
     * Updates and validates the volume number of this journal edition.
     * @param Volume Positive int representing the updated volume number of this journal edition
     */
    public void setVolume(int Volume) {
        if(Volume<0)
        {
            throw new IllegalArgumentException("This is not a valid volume.");
        }
        this.Volume = Volume;
    }

    /**
     * Gets the issue number of this journal edition.
     * @return Int representing the issue number of this journal edition
     */
    public int getIssue() {
        return Issue;
    }

    /**
     * Updates and validates the issue number of this journal edition.
     * @param Issue Positive int representing the updated issue number of this journal edition
     */
    public void setIssue(int Issue) {
        if(Issue<0)
        {
            throw new IllegalArgumentException("This is not a valid issue.");
        }
        this.Issue = Issue;
    }

    /**
     * Gets the publisher of this newspaper edition.
     * @return String representing the name of the publisher of this newspaper edition
     */
    public String getPublisher(){
        return Publisher;
    }

    /**
     * Updates the publisher of this newspaper edition.
     * @param Publisher String representing the new name of the publisher of this newspaper edition
     */
    public void setPublisher(String Publisher){
        this.Publisher = Publisher;
    }


    //TODO: Finish filling out the documentation for the parameters here
    /**
     * Constructs a Journal item for the collection. Each edition of a journal in the library should be represented by one instance of this object
     * @param ISSN
     * @param section LibrarySection enum representing the section of the library in which this journal can be found.
     * @param volume
     * @param issue
     * @param Publisher
     * @param Title
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this journal in the library collection
     * @param price Float representing the price of one copy of this journal (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this journal that will currently be available to borrow
     */
    public LibraryJournal(int[] ISSN, LibrarySection section, int volume, int issue, String Publisher, String Title, char[] ID_num, float price, int numberAvailable){

        super(ID_num, section, price, numberAvailable);
        setISSN(ISSN);
        setVolume(volume);
        setIssue(issue);
        setPublisher(Publisher);
        setTitle(Title);
    }
}
